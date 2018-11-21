package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ProjectEventTypeDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectEventTypeDTOMapperTest extends XmEntityDTOMapperAbstractTest<ProjectEventTypeDTO> {

    public ProjectEventTypeDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ProjectEventTypeDTO buildTestDto() {
        return TestDataUtils.buildTestProjectEventTypeDTO();
    }

    @Override
    protected Class<ProjectEventTypeDTO> getDtoClass() {
        return ProjectEventTypeDTO.class;
    }
}
