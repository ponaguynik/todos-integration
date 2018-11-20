package com.example.todosintegration.web.rest;

import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import com.example.todosintegration.service.dto.CreditorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: 20-Nov-18 move DTOs to separate resources. Consider creating abstract resource
@Slf4j
@RequestMapping("/api")
@RestController
public class XmEntityDtoResource {
    private final XmEntityDtoService xmEntityDtoService;
    private final XmEntityService xmEntityService;

    @Autowired
    public XmEntityDtoResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        this.xmEntityDtoService = xmEntityDtoService;
        this.xmEntityService = xmEntityService;
    }

    @GetMapping(value = "/creditors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CreditorDTO> getAllCreditors() {
        log.debug("REST request to get all Creditors");
        return xmEntityDtoService.findAllByTypeKey(CreditorDTO.TYPE_KEY, CreditorDTO.class);
    }

    @PostMapping(value = "/creditors/load", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void loadCreditors() {
        log.debug("REST request to load Creditors from entity service");
        xmEntityService.loadByTypeKey(CreditorDTO.TYPE_KEY);
    }
}
