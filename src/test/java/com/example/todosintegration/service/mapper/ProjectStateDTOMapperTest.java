package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectStateDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectStateDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectStateDTO> {

    public ProjectStateDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectStateDTO buildTestDto() {
        return TestDataUtils.buildTestProjectStateDTO();
    }

    @Override
    protected Class<ProjectStateDTO> getDtoClass() {
        return ProjectStateDTO.class;
    }
}
