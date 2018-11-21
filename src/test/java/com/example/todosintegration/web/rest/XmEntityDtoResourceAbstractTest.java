package com.example.todosintegration.web.rest;

import com.example.todosintegration.TodosIntegrationApplication;
import com.example.todosintegration.client.EntityClient;
import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.exception.UnableLoadXmEntityException;
import com.example.todosintegration.repository.XmEntityRepository;
import com.example.todosintegration.util.TestDataUtils;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodosIntegrationApplication.class)
@Transactional
public abstract class XmEntityDtoResourceAbstractTest<T extends XmEntityDTO> {
    @Autowired
    protected AbstractXmEntityDtoResource<T> resource;
    @Autowired
    protected XmEntityRepository xmEntityRepository;
    @Autowired
    protected MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @MockBean
    protected EntityClient entityClient;

    protected MockMvc mockMvc;

    protected XmEntity xmEntity;
    protected T dto;

    protected abstract T buildTestDto();

    protected abstract XmEntityType getEntityType();

    protected abstract String apiPath();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(resource)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTests() {
        xmEntity = TestDataUtils.buildTestXmEntity();
        xmEntity.setTypeKey(getEntityType().getTypeKey());
        dto = buildTestDto();
        xmEntity.setData(toJson(dto));
    }

    @Test
    public void testLoadXmEntityDtos() throws Exception {
        doReturn(Collections.singletonList(xmEntity))
                .when(entityClient).getAllXmEntitiesByTypeKey(eq(getEntityType().getTypeKey()));

        mockMvc.perform(post(apiPath() + "/load"))
                .andExpect(status().isOk());
        xmEntityRepository.flush();

        verify(entityClient).getAllXmEntitiesByTypeKey(eq(getEntityType().getTypeKey()));
        List<XmEntity> dbXmEntities = xmEntityRepository.findAllByTypeKey(getEntityType().getTypeKey());
        assertFalse(dbXmEntities.isEmpty());
        assertEquals(xmEntity, dbXmEntities.get(0));
    }

    @Test(expected = UnableLoadXmEntityException.class)
    public void testLoadXmEntityDtosFailedLoadEntitiesFromEntityService() throws Throwable {
        doThrow(mock(FeignException.class)).when(entityClient).getAllXmEntitiesByTypeKey(anyString());

        try {
            mockMvc.perform(post(apiPath() + "/load"))
                    .andExpect(status().is5xxServerError());
        } catch (NestedServletException e) {
            if (e.getCause() != null && e.getCause() instanceof UnableLoadXmEntityException) {
                throw e.getCause();
            }
            throw e;
        }
    }

    @Test
    public void testLoadXmEntityDtosLoadEmptyList() throws Throwable {
        doReturn(Collections.emptyList()).when(entityClient).getAllXmEntitiesByTypeKey(eq(getEntityType().getTypeKey()));

        mockMvc.perform(post(apiPath() + "/load"))
                .andExpect(status().isOk());

        verify(entityClient).getAllXmEntitiesByTypeKey(eq(getEntityType().getTypeKey()));
        List<XmEntity> dbXmEntities = xmEntityRepository.findAllByTypeKey(getEntityType().getTypeKey());
        assertTrue(dbXmEntities.isEmpty());
    }

    @Test
    public void testGetAllXmEntityDtos() throws Exception {
        xmEntityRepository.saveAndFlush(xmEntity);

        mockMvc.perform(get(apiPath()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(toJson(asArray(dto))));
    }

    @Test
    public void testGetAllXmEntityDtosEmptyResult() throws Exception {
        mockMvc.perform(get(apiPath()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json("[]"));
    }
}
