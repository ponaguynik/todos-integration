package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectFieldDTO;

public class ProjectFieldDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectFieldDTO> {

    public ProjectFieldDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectFieldDTO buildTestDto() {
        return ProjectFieldDTO.builder()
                .fieldId(1L)
                .fieldNameEng("field name")
                .fieldNameUkr("назва")
                .build();
    }

    @Override
    protected Class<ProjectFieldDTO> getDtoClass() {
        return ProjectFieldDTO.class;
    }
}
