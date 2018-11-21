package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.NewsDTO;

import java.util.Arrays;

public class NewsResourceTest extends XmEntityDtoResourceAbstractTest<NewsDTO> {
    private static final String API_PATH = "/api/news";

    @Override
    protected NewsDTO buildTestDto() {
        return NewsDTO.builder()
                .newsId(1L)
                .newsTitle("Title")
                .newsText("text")
                .lang("ua")
                .newsDate("21-Nov-18")
                .attachments(Arrays.asList(
                        NewsDTO.DocAttachmentDTO.builder()
                                .docId(1L)
                                .docName("doc name")
                                .fileName("file name")
                                .fileSize("10M").build(),
                        NewsDTO.DocAttachmentDTO.builder()
                                .docId(2L)
                                .docName("doc name 1")
                                .fileName("file name 1")
                                .fileSize("15M").build()
                )).build();
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