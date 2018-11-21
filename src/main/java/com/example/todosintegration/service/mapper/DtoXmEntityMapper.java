package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.service.mapper.exception.MappingFailedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import java.io.IOException;

/**
 * Mapper for a {@link XmEntity} to/from a {@link XmEntityDTO}
 */
public interface DtoXmEntityMapper<DTO extends XmEntityDTO> {
    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Map from XmEntity to the concrete XmEntityDTO.
     *
     * @param entity   to map
     * @param dtoClass the class of the concrete XmEntityDTO
     * @return mapped XmEntityDTO of {@code dtoClass} type
     * @throws MappingFailedException if failed to read data as JSON string
     */
    default DTO toDto(XmEntity entity, Class<DTO> dtoClass) {
        if (entity == null) {
            return null;
        }
        if (Strings.isNullOrEmpty(entity.getData())) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(entity.getData(), dtoClass);
        } catch (IOException e) {
            throw new MappingFailedException(e);
        }
    }

    /**
     * Map from XmEntityDTO to XmEntity.
     *
     * @return mapped XmEntity
     * @throws MappingFailedException if failed to write data as JSON string
     */
    default XmEntity fromDto(DTO dto) {
        if (dto == null) {
            return null;
        }
        XmEntity xmEntity = new XmEntity();
        try {
            xmEntity.setData(OBJECT_MAPPER.writeValueAsString(dto));
            return xmEntity;
        } catch (JsonProcessingException e) {
            throw new MappingFailedException(e);
        }
    }

    /**
     * @return true if an implementation can process DTO of {@code dtoClass} type
     */
    boolean supports(Class<? extends XmEntityDTO> dtoClass);
}
