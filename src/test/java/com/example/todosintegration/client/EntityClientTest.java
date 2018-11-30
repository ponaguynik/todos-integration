package com.example.todosintegration.client;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.*;
import com.example.todosintegration.service.mapper.XmEntityMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@Profile("test-entity")
public class EntityClientTest extends FeignClientAbstractTest {
    @Autowired
    private EntityClient entityClient;
    @Autowired
    private XmEntityMapper mapper;

    @Test
    public void testGetAllCreditorXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.CREDITOR.getTypeKey());
        CreditorDTO creditorDTO = mapper.toDto(xmEntities.get(0), CreditorDTO.class);

        assertNotNull(creditorDTO);
        assertNotNull(xmEntities);
    }

    @Test
    public void testGetAllProjectStateXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT_STATE.getTypeKey());
        ProjectStateDTO projectStateDTO = mapper.toDto(xmEntities.get(0), ProjectStateDTO.class);

        assertNotNull(projectStateDTO);
        assertNotNull(xmEntities);
    }

    @Test
    public void testGetAllProjectEventTypeXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT_EVENT_TYPE.getTypeKey());
        ProjectEventTypeDTO projectEventTypeDTO = mapper.toDto(xmEntities.get(0), ProjectEventTypeDTO.class);

        assertNotNull(projectEventTypeDTO);
        assertNotNull(xmEntities);
    }

    @Test
    public void testGetAllProjectFieldXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT_FIELD.getTypeKey());
        ProjectFieldDTO projectFieldDTO = mapper.toDto(xmEntities.get(0), ProjectFieldDTO.class);

        assertNotNull(projectFieldDTO);
        assertNotNull(xmEntities);
    }

    @Test
    public void testGetAllResponsibleExecutorXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.RESPONSIBLE_EXECUTOR.getTypeKey());
        ResponsibleExecutorDTO responsibleExecutorDTO = mapper.toDto(xmEntities.get(0), ResponsibleExecutorDTO.class);

        assertNotNull(responsibleExecutorDTO);
        assertNotNull(xmEntities);
    }

    @Test
    public void testGetAllNewsXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.NEWS.getTypeKey());
        NewsDTO newsDTO = mapper.toDto(xmEntities.get(0), NewsDTO.class);

        assertNotNull(newsDTO);
        assertNotNull(xmEntities);
    }

    @Test
    public void testGetAllProjectXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT.getTypeKey());
        ProjectDTO projectDTO = mapper.toDto(xmEntities.get(0), ProjectDTO.class);

        assertNotNull(projectDTO);
        assertNotNull(xmEntities);
    }
}