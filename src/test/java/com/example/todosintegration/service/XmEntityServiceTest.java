package com.example.todosintegration.service;

import com.example.todosintegration.client.EntityClient;
import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.exception.UnableLoadXmEntityException;
import com.example.todosintegration.repository.XmEntityRepository;
import com.example.todosintegration.util.TestDataUtils;
import feign.FeignException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class XmEntityServiceTest {
    private static final XmEntityType DEFAULT_XM_ENTITY_TYPE = XmEntityType.CREDITOR;

    @Mock
    private EntityClient entityClient;
    @Mock
    private XmEntityRepository xmEntityRepository;

    @InjectMocks
    private XmEntityService xmEntityService;

    private XmEntity xmEntity;

    @Before
    public void init() {
        xmEntity = TestDataUtils.buildTestXmEntity();
    }

    @Test
    public void testLoadOfXmEntityType() {
        List<XmEntity> entities = Collections.singletonList(xmEntity);
        when(entityClient.getAllXmEntitiesByTypeKey(eq(DEFAULT_XM_ENTITY_TYPE.getTypeKey())))
                .thenReturn(entities);

        xmEntityService.loadOfXmEntityType(DEFAULT_XM_ENTITY_TYPE);
        verify(entityClient).getAllXmEntitiesByTypeKey(eq(DEFAULT_XM_ENTITY_TYPE.getTypeKey()));
        verify(xmEntityRepository).saveAll(eq(entities));
    }

    @Test(expected = UnableLoadXmEntityException.class)
    public void testLoadOfXmEntityTypeFailedLoadXmEntitiesFromEntityService() {
        when(entityClient.getAllXmEntitiesByTypeKey(anyString())).thenThrow(mock(FeignException.class));

        xmEntityService.loadOfXmEntityType(DEFAULT_XM_ENTITY_TYPE);
    }
}