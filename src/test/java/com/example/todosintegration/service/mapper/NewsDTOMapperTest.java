package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.NewsDTO;
import com.example.todosintegration.util.TestDataUtils;

public class NewsDTOMapperTest extends XmEntityDTOMapperAbstractTest<NewsDTO> {

    public NewsDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected NewsDTO buildTestDto() {
        return TestDataUtils.buildTestNewsDTO();
    }

    @Override
    protected Class<NewsDTO> getDtoClass() {
        return NewsDTO.class;
    }
}
