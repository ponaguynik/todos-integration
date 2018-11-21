package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
public abstract class AbstractXmEntityDtoResource<T extends XmEntityDTO> {
    private final XmEntityDtoService xmEntityDtoService;
    private final XmEntityService xmEntityService;

    protected AbstractXmEntityDtoResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        this.xmEntityDtoService = xmEntityDtoService;
        this.xmEntityService = xmEntityService;
    }

    protected abstract Class<T> getDtoClass();

    protected abstract XmEntityType getXmEntityType();

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<T> getAllXmEntityDtos() {
        log.debug("REST request to get all {}s", getDtoClass().getSimpleName());
        return xmEntityDtoService.findAllOfXmEntityType(getXmEntityType(), getDtoClass());
    }

    @PostMapping(value = "/load")
    public void loadXmEntityDtos() {
        log.debug("REST request to load {} from entity service", getDtoClass().getSimpleName());
        xmEntityService.loadOfXmEntityType(getXmEntityType());
    }
}
