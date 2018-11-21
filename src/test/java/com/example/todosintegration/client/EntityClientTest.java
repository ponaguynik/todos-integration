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
}