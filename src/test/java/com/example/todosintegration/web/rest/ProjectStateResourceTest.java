package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectStateDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectStateResourceTest extends XmEntityDtoResourceAbstractTest<ProjectStateDTO> {
    private static final String API_PATH = "/api/project-states";

    @Override
    protected ProjectStateDTO buildTestDto() {
        return TestDataUtils.buildTestProjectStateDTO();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.PROJECT_STATE;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}