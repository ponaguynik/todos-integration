package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.CreditorDTO;

public class CreditorResourceTest extends AbstractXmEntityDtoResourceTest<CreditorDTO> {
    private static final String API_PATH = "/api/creditors";

    @Override
    protected CreditorDTO getTestDto() {
        return CreditorDTO.builder()
                .creditorId(1L)
                .creditorCode("creditor_code")
                .creditorName("creditor_name").build();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.CREDITOR;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}