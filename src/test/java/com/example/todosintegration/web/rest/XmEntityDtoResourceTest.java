package com.example.todosintegration.web.rest;

import com.example.todosintegration.TodosIntegrationApplication;
import com.example.todosintegration.client.EntityClient;
import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.exception.UnableLoadXmEntityException;
import com.example.todosintegration.repository.XmEntityRepository;
import com.example.todosintegration.service.dto.CreditorDTO;
import feign.FeignException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import java.util.Collections;
import java.util.List;

import static com.example.todosintegration.util.TestUtils.asArray;
import static com.example.todosintegration.util.TestUtils.toJson;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodosIntegrationApplication.class)
@Transactional
public class XmEntityDtoResourceTest {

    @Autowired
    private XmEntityDtoResource dtoResource;
    @Autowired
    private XmEntityRepository xmEntityRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @MockBean
    private EntityClient entityClient;

    private MockMvc mockMvc;

    private XmEntity xmEntity;
    private CreditorDTO creditorDTO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(dtoResource)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTests() {
        xmEntity = new XmEntity();
        xmEntity.setId(1L);
        xmEntity.setTypeKey(CreditorDTO.TYPE_KEY);
        creditorDTO = CreditorDTO.builder()
                .creditorId(1L)
                .creditorCode("creditor_code")
                .creditorName("creditor_name").build();
        xmEntity.setData(toJson(creditorDTO));
    }

    @Test
    public void testLoadCreditors() throws Exception {
        doReturn(Collections.singletonList(xmEntity)).when(entityClient).getAllXmEntitiesByTypeKey(eq(CreditorDTO.TYPE_KEY));

        mockMvc.perform(post("/api/creditors/load"))
                .andExpect(status().isOk());
        xmEntityRepository.flush();

        verify(entityClient).getAllXmEntitiesByTypeKey(eq(CreditorDTO.TYPE_KEY));
        List<XmEntity> dbXmEntities = xmEntityRepository.findAllByTypeKey(CreditorDTO.TYPE_KEY);
        assertFalse(dbXmEntities.isEmpty());
        assertEquals(xmEntity, dbXmEntities.get(0));
    }

    @Test(expected = UnableLoadXmEntityException.class)
    public void testLoadCreditorsFailedLoadEntitiesFromEntityService() throws Throwable {
        doThrow(mock(FeignException.class)).when(entityClient).getAllXmEntitiesByTypeKey(anyString());

        try {
            mockMvc.perform(post("/api/creditors/load"))
                    .andExpect(status().is5xxServerError());
        } catch (NestedServletException e) {
            if (e.getCause() != null && e.getCause() instanceof UnableLoadXmEntityException) {
                throw e.getCause();
            }
            throw e;
        }
    }

    @Test
    public void testLoadCreditorsLoadEmptyList() throws Throwable {
        doReturn(Collections.emptyList()).when(entityClient).getAllXmEntitiesByTypeKey(eq(CreditorDTO.TYPE_KEY));

        mockMvc.perform(post("/api/creditors/load"))
                .andExpect(status().isOk());

        verify(entityClient).getAllXmEntitiesByTypeKey(eq(CreditorDTO.TYPE_KEY));
        List<XmEntity> dbXmEntities = xmEntityRepository.findAllByTypeKey(CreditorDTO.TYPE_KEY);
        assertTrue(dbXmEntities.isEmpty());
    }

    @Test
    public void testGetAllCreditors() throws Exception {
        xmEntityRepository.saveAndFlush(xmEntity);

        mockMvc.perform(get("/api/creditors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(toJson(asArray(creditorDTO))));
    }

    @Test
    public void testGetAllCreditorsEmptyResult() throws Exception {
        mockMvc.perform(get("/api/creditors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json("[]"));
    }
}