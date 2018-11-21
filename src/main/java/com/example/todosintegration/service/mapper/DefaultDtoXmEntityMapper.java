package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.dto.XmEntityDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Default implementation of the {@link DtoXmEntityMapper}.
 * This implementation is autowired as the last mapper of the list due {@link Order} annotation
 * and used only if there is no other implementation for a specific {@link XmEntityDTO}.
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Component
public class DefaultDtoXmEntityMapper<DTO extends XmEntityDTO> implements DtoXmEntityMapper<DTO> {

    @Override
    public boolean supports(Class<? extends XmEntityDTO> dtoClass) {
        return true;
    }
}
