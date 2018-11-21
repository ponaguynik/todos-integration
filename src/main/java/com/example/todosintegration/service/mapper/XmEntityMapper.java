package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.service.mapper.exception.MapperNotFoundException;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Facade for all {@link DtoXmEntityMapper} implementations
 */
@SuppressWarnings("unchecked")
@Component
public class XmEntityMapper {
    // autowire mappers in order (default implementation must be at the end of the list)
    //
    // WARNING: use @Order(1) annotation over a custom implementation so default impl is
    // injected last one in the list, otherwise default impl will be the first one in the list.
    private final List<DtoXmEntityMapper> mappers;

    @Autowired
    public XmEntityMapper(List<DtoXmEntityMapper> mappers) {
        this.mappers = mappers != null ? mappers : Collections.emptyList();
    }

    public <DTO extends XmEntityDTO> XmEntity fromDto(DTO dto) {
        if (dto == null) {
            return null;
        }
        DtoXmEntityMapper mapper = findMapper(dto.getClass()).orElseThrow(mapperNotFoundFor(dto.getClass()));
        return mapper.fromDto(dto);
    }

    public <DTO extends XmEntityDTO> DTO toDto(XmEntity xmEntity, Class<DTO> dtoClass) {
        if (xmEntity == null) {
            return null;
        }
        Preconditions.checkNotNull(dtoClass);
        DtoXmEntityMapper mapper = findMapper(dtoClass).orElseThrow(mapperNotFoundFor(dtoClass));
        return (DTO) mapper.toDto(xmEntity, dtoClass);
    }

    private <DTO extends XmEntityDTO> Optional<DtoXmEntityMapper> findMapper(Class<DTO> dtoClass) {
        for (DtoXmEntityMapper mapper : mappers) {
            if (mapper.supports(dtoClass)) {
                return Optional.of(mapper);
            }
        }
        return Optional.empty();
    }

    private Supplier<MapperNotFoundException> mapperNotFoundFor(Class<?> c) {
        return () -> new MapperNotFoundException("Mapper not found for " + c.getSimpleName());
    }

    public List<DtoXmEntityMapper> getMappers() {
        return new ArrayList<>(mappers);
    }

}
