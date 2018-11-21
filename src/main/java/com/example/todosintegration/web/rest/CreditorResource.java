package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.CreditorDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditors")
public class CreditorResource extends AbstractXmEntityDtoResource<CreditorDTO> {

    @Autowired
    public CreditorResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        super(xmEntityDtoService, xmEntityService);
    }

    @Override
    protected Class<CreditorDTO> getDtoClass() {
        return CreditorDTO.class;
    }

    @Override
    protected XmEntityType getXmEntityType() {
        return XmEntityType.CREDITOR;
    }
}
