package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectResourceTest extends XmEntityDtoResourceAbstractTest<ProjectDTO> {
    private static final String API_PATH = "/api/projects";

    @Override
    protected ProjectDTO buildTestDto() {
        return TestDataUtils.buildTestProjectDTO();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.PROJECT;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}