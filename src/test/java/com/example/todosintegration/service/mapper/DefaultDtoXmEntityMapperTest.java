package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.dto.CreditorDTO;
import com.example.todosintegration.service.mapper.exception.MappingFailedException;
import org.junit.Before;
import org.junit.Test;

import static com.example.todosintegration.util.TestUtils.toJson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DefaultDtoXmEntityMapperTest {
    private DefaultDtoXmEntityMapper<CreditorDTO> mapper = new DefaultDtoXmEntityMapper<>();

    private XmEntity xmEntity;
    private CreditorDTO dto;

    @Before
    public void initTests() {
        dto = CreditorDTO.builder()
                .creditorId(1L)
                .creditorCode("creditor_code")
                .creditorName("Creditor Name").build();
        xmEntity = new XmEntity();
        xmEntity.setData(toJson(dto));
    }

    @Test
    public void testToDto() {
        CreditorDTO mappedDto = mapper.toDto(xmEntity, CreditorDTO.class);

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
        mapper.toDto(xmEntity, CreditorDTO.class);
    }

    @Test
    public void testToDtoNullData() {
        xmEntity.setData(null);
        CreditorDTO mappedDto = mapper.toDto(xmEntity, CreditorDTO.class);

        assertNull(mappedDto);
    }
}