package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.NewsDTO;
import com.example.todosintegration.util.TestDataUtils;

public class NewsResourceTest extends XmEntityDtoResourceAbstractTest<NewsDTO> {
    private static final String API_PATH = "/api/news";

    @Override
    protected NewsDTO buildTestDto() {
        return TestDataUtils.buildTestNewsDTO();
    }

    @Override
    protected XmEntityType getEntityType() {
        return XmEntityType.NEWS;
    }

    @Override
    protected String apiPath() {
        return API_PATH;
    }
}