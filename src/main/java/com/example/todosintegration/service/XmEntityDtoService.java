package com.example.todosintegration.service;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.repository.XmEntityRepository;
import com.example.todosintegration.service.mapper.XmEntityMapper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class XmEntityDtoService {
    private final XmEntityRepository xmEntityRepository;
    private final XmEntityMapper mapper;

    @Autowired
    public XmEntityDtoService(XmEntityRepository xmEntityRepository, XmEntityMapper mapper) {
        this.xmEntityRepository = xmEntityRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public <T extends XmEntityDTO> List<T> findAllOfXmEntityType(XmEntityType xmEntityType, Class<T> dtoClass) {
        Preconditions.checkNotNull(xmEntityType);
        Preconditions.checkNotNull(dtoClass);
        Preconditions.checkArgument(xmEntityType.getDtoClass() == dtoClass,
                "XmEntityType dtoClass doesn't match passed dtoClass");

        List<XmEntity> xmEntities = xmEntityRepository.findAllByTypeKey(xmEntityType.getTypeKey());
        return xmEntities.stream()
                .map(entity -> mapper.toDto(entity, dtoClass))
                .collect(Collectors.toList());
    }
}
