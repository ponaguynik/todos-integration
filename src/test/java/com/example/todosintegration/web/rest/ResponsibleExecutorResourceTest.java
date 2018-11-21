package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ResponsibleExecutorDTO;

public class ResponsibleExecutorResourceTest extends XmEntityDtoResourceAbstractTest<ResponsibleExecutorDTO> {
    private static final String API_PATH = "/api/responsible-executors";

    @Override
    protected ResponsibleExecutorDTO buildTestDto() {
        return ResponsibleExecutorDTO.builder()
                .responsibleExecutorId(1L)
                .responsibleExecutorNameEng("name")
                .responsibleExecutorNameUkr("назва")
                .build();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.RESPONSIBLE_EXECUTOR;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}