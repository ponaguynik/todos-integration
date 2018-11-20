package com.example.todosintegration.client;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.service.dto.CreditorDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static org.junit.Assert.*;

@Profile("test-entity")
public class EntityClientTest extends AbstractFeignClientTest {
    @Autowired
    private EntityClient entityClient;

    @Test
    public void testGetAllXmEntities() {
        List<XmEntity> xmEntities = entityClient.getAllXmEntitiesByTypeKey(CreditorDTO.TYPE_KEY);

        assertNotNull(xmEntities);
        assertFalse(xmEntities.isEmpty());
        assertEquals(CreditorDTO.TYPE_KEY, xmEntities.get(0).getTypeKey());
    }
}