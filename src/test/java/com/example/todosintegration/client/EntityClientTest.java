package com.example.todosintegration.client;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static org.junit.Assert.*;

@Profile("test-entity")
public class EntityClientTest extends FeignClientAbstractTest {
    @Autowired
    private EntityClient entityClient;

    @Test
    public void testGetAllCreditorXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.CREDITOR.getTypeKey());

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(XmEntityType.CREDITOR.getTypeKey(), xmEntities.get(0).getTypeKey());
    }

    @Test
    public void testGetAllProjectStateXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT_STATE.getTypeKey());

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(XmEntityType.PROJECT_STATE.getTypeKey(), xmEntities.get(0).getTypeKey());
    }

    @Test
    public void testGetAllProjectEventTypeXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT_EVENT_TYPE.getTypeKey());

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(XmEntityType.PROJECT_EVENT_TYPE.getTypeKey(), xmEntities.get(0).getTypeKey());
    }

    @Test
    public void testGetAllProjectFieldXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.PROJECT_FIELD.getTypeKey());

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(XmEntityType.PROJECT_FIELD.getTypeKey(), xmEntities.get(0).getTypeKey());
    }

    @Test
    public void testGetAllResponsibleExecutorXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.RESPONSIBLE_EXECUTOR.getTypeKey());

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(XmEntityType.RESPONSIBLE_EXECUTOR.getTypeKey(), xmEntities.get(0).getTypeKey());
    }

    @Test
    public void testGetAllNewsXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(XmEntityType.NEWS.getTypeKey());

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(XmEntityType.NEWS.getTypeKey(), xmEntities.get(0).getTypeKey());
    }
}