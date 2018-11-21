package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.service.mapper.exception.MappingFailedException;
import org.junit.Before;
import org.junit.Test;

import static com.example.todosintegration.util.TestUtils.toJson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public abstract class XmEntityDTOMapperAbstractTest<T extends XmEntityDTO> {
    protected final DtoXmEntityMapper<T> mapper;

    protected XmEntity xmEntity;
    protected T dto;

    protected XmEntityDTOMapperAbstractTest(DtoXmEntityMapper<T> mapper) {
        this.mapper = mapper;
    }

    protected abstract T buildTestDto();

    protected abstract Class<T> getDtoClass();

    @Before
    public void initTests() {
        dto = buildTestDto();
        xmEntity = new XmEntity();
        xmEntity.setData(toJson(dto));
    }

    @Test
    public void testToDto() {
        T mappedDto = mapper.toDto(xmEntity, getDtoClass());

        assertEquals(dto, mappedDto);
    }

    @Test
    public void testFromDto() {
        XmEntity mappedEntity = mapper.fromDto(dto);

        assertEquals(xmEntity, mappedEntity);
    }

    @Test(expected = MappingFailedException.class)
    public void testToDtoNotValidXmEntityData() {
        xmEntity.setData("{not valid json");
        mapper.toDto(xmEntity, getDtoClass());
    }

    @Test
    public void testToDtoNullData() {
        xmEntity.setData(null);
        T mappedDto = mapper.toDto(xmEntity, getDtoClass());

        assertNull(mappedDto);
    }
}
