package com.example.todosintegration.service;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.CreditorDTO;
import com.example.todosintegration.repository.XmEntityRepository;
import com.example.todosintegration.service.mapper.XmEntityMapper;
import com.example.todosintegration.util.TestDataUtils;
import com.example.todosintegration.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class XmEntityDtoServiceTest {
    @Mock
    private XmEntityRepository xmEntityRepository;
    @Mock
    private XmEntityMapper mapper;
    @InjectMocks
    private XmEntityDtoService dtoService;

    private XmEntity xmEntity;
    private CreditorDTO creditorDTO;

    @Before
    public void init() {
        creditorDTO = TestDataUtils.buildTestCreditorDTO();
        xmEntity = TestDataUtils.buildTestXmEntity();
        xmEntity.setTypeKey(XmEntityType.CREDITOR.getTypeKey());
        xmEntity.setData(TestUtils.toJson(creditorDTO));
    }

    @Test
    public void testFindAllOfXmEntityType() {
        when(xmEntityRepository.findAllByTypeKey(eq(xmEntity.getTypeKey()))).thenReturn(Collections.singletonList(xmEntity));
        when(mapper.toDto(eq(xmEntity), eq(CreditorDTO.class))).thenReturn(creditorDTO);

        List<CreditorDTO> dtos = dtoService.findAllOfXmEntityType(XmEntityType.CREDITOR, CreditorDTO.class);

        verify(mapper).toDto(eq(xmEntity), eq(CreditorDTO.class));
        assertFalse(dtos.isEmpty());
        assertEquals(creditorDTO, dtos.get(0));
    }

    @Test
    public void testFindAllOfXmEntityTypeEmpty() {
        when(xmEntityRepository.findAllByTypeKey(eq(xmEntity.getTypeKey()))).thenReturn(Collections.emptyList());

        List<CreditorDTO> dtos = dtoService.findAllOfXmEntityType(XmEntityType.CREDITOR, CreditorDTO.class);

        verifyZeroInteractions(mapper);
        assertTrue(dtos.isEmpty());
    }
}