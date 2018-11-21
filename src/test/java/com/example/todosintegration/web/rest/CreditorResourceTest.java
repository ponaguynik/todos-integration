package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.CreditorDTO;
import com.example.todosintegration.util.TestDataUtils;

public class CreditorResourceTest extends XmEntityDtoResourceAbstractTest<CreditorDTO> {
    private static final String API_PATH = "/api/creditors";

    @Override
    protected CreditorDTO buildTestDto() {
        return TestDataUtils.buildTestCreditorDTO();
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