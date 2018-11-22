package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectDTO> {

    public ProjectDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectDTO buildTestDto() {
        return TestDataUtils.buildTestProjectDTO();
    }

    @Override
    protected Class<ProjectDTO> getDtoClass() {
        return ProjectDTO.class;
    }
}
