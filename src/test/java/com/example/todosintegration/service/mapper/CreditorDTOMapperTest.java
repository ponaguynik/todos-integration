package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.CreditorDTO;

public class CreditorDTOMapperTest extends XmEntityDTOMapperAbstractTest<CreditorDTO> {

    public CreditorDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected CreditorDTO buildTestDto() {
        return CreditorDTO.builder()
                .creditorId(1L)
                .creditorCode("creditor_code")
                .creditorName("Creditor Name").build();
    }

    @Override
    protected Class<CreditorDTO> getDtoClass() {
        return CreditorDTO.class;
    }
}
