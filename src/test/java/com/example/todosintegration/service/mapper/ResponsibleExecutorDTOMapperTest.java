package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.ResponsibleExecutorDTO;
import com.example.todosintegration.util.TestDataUtils;

public class ResponsibleExecutorDTOMapperTest extends XmEntityDTOMapperAbstractTest<ResponsibleExecutorDTO> {

    public ResponsibleExecutorDTOMapperTest() {
        super(new DefaultDtoXmEntityMapper<>());
    }

    @Override
    protected ResponsibleExecutorDTO buildTestDto() {
        return TestDataUtils.buildTestResponsibleExecutorDTO();
    }

    @Override
    protected Class<ResponsibleExecutorDTO> getDtoClass() {
        return ResponsibleExecutorDTO.class;
    }
}
