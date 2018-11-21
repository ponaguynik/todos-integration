package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectEventTypeDTO;

public class ProjectEventTypeDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectEventTypeDTO> {

    public ProjectEventTypeDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectEventTypeDTO buildTestDto() {
        return ProjectEventTypeDTO.builder()
                .eventTypeCode("type_code")
                .eventTypeNameEng("type name")
                .eventTypeNameUkr("назвва типу")
                .build();
    }

    @Override
    protected Class<ProjectEventTypeDTO> getDtoClass() {
        return ProjectEventTypeDTO.class;
    }
}
