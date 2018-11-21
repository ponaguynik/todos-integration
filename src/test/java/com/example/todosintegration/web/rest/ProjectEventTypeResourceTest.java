package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectEventTypeDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ProjectEventTypeResourceTest extends XmEntityDtoResourceAbstractTest<ProjectEventTypeDTO> {
    private static final String API_PATH = "/api/project-event-types";

    @Override
    protected ProjectEventTypeDTO buildTestDto() {
        return TestDataUtils.buildTestProjectEventTypeDTO();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.PROJECT_EVENT_TYPE;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}