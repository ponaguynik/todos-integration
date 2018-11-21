package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.CreditorDTO;
import com.example.todosintegration.util.TestDataUtils;

public class CreditorDTOMapperTest extends XmEntityDTOMapperAbstractTest<CreditorDTO> {

    public CreditorDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected CreditorDTO buildTestDto() {
        return TestDataUtils.buildTestCreditorDTO();
    }

    @Override
    protected Class<CreditorDTO> getDtoClass() {
        return CreditorDTO.class;
    }
}
