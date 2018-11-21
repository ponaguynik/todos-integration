package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.NewsDTO;

import java.util.Arrays;

public class NewsDTOMapperTest extends XmEntityDTOMapperAbstractTest<NewsDTO> {

    public NewsDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

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
    protected Class<NewsDTO> getDtoClass() {
        return NewsDTO.class;
    }
}
