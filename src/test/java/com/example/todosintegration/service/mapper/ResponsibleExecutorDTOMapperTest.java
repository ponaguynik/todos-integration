package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ResponsibleExecutorDTO;

public class ResponsibleExecutorDTOMapperTest extends XmEntityDTOMapperAbstractTest<ResponsibleExecutorDTO> {

    public ResponsibleExecutorDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ResponsibleExecutorDTO buildTestDto() {
        return ResponsibleExecutorDTO.builder()
                .responsibleExecutorId(1L)
                .responsibleExecutorNameEng("name")
                .responsibleExecutorNameUkr("назва")
                .build();
    }

    @Override
    protected Class<ResponsibleExecutorDTO> getDtoClass() {
        return ResponsibleExecutorDTO.class;
    }
}
