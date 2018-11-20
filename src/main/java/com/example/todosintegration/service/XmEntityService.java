package com.example.todosintegration.service;

import com.example.todosintegration.client.EntityClient;
import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.exception.UnableLoadXmEntityException;
import com.example.todosintegration.repository.XmEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class XmEntityService {
    private final EntityClient entityClient;
    private final XmEntityRepository xmEntityRepository;

    @Autowired
    public XmEntityService(EntityClient entityClient, XmEntityRepository xmEntityRepository) {
        this.entityClient = entityClient;
        this.xmEntityRepository = xmEntityRepository;
    }

    @Transactional
    public void loadByTypeKey(String typeKey) {
        List<XmEntity> xmEntities;
        try {
            xmEntities = entityClient.getAllXmEntitiesByTypeKey(typeKey);
        } catch (Exception e) {
            log.error("Failed to load XmEntities", e);
            throw new UnableLoadXmEntityException("Failed to load XmEntities by typeKey '" + typeKey + "'. Cause: " + e.getMessage());
        }
        log.debug("Got {} XmEntities with typeKey '{}' from '{}'. Saving to the database", xmEntities.size(), typeKey,
                EntityClient.SERVICE_NAME);
        xmEntityRepository.saveAll(xmEntities);
    }
}
