package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectFieldDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectFieldResourceTest extends XmEntityDtoResourceAbstractTest<ProjectFieldDTO> {
    private static final String API_PATH = "/api/project-fields";

    @Override
    protected ProjectFieldDTO buildTestDto() {
        return TestDataUtils.buildTestProjectFieldDTO();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.PROJECT_FIELD;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}