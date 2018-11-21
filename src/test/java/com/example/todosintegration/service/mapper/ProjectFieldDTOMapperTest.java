package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectFieldDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectFieldDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectFieldDTO> {

    public ProjectFieldDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectFieldDTO buildTestDto() {
        return TestDataUtils.buildTestProjectFieldDTO();
    }

    @Override
    protected Class<ProjectFieldDTO> getDtoClass() {
        return ProjectFieldDTO.class;
    }
}
