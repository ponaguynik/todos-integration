package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ResponsibleExecutorDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/responsible-executors")
public class ResponsibleExecutorResource extends AbstractXmEntityDtoResource<ResponsibleExecutorDTO> {

    @Autowired
    public ResponsibleExecutorResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        super(xmEntityDtoService, xmEntityService);
    }

    @Override
    protected Class<ResponsibleExecutorDTO> getDtoClass() {
        return ResponsibleExecutorDTO.class;
    }

    @Override
    protected XmEntityType getXmEntityType() {
        return XmEntityType.RESPONSIBLE_EXECUTOR;
    }
}
