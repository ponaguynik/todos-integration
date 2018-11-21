package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectStateDTO;

public class ProjectStateDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectStateDTO> {

    public ProjectStateDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectStateDTO buildTestDto() {
        return ProjectStateDTO.builder()
                .stateId(1L)
                .stateNameEng("state_name")
                .stateNameUkr("стан проекту").build();
    }

    @Override
    protected Class<ProjectStateDTO> getDtoClass() {
        return ProjectStateDTO.class;
    }
}
