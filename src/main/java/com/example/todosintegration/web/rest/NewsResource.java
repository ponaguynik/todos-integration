package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.NewsDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsResource extends AbstractXmEntityDtoResource<NewsDTO> {

    @Autowired
    public NewsResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        super(xmEntityDtoService, xmEntityService);
    }

    @Override
    protected Class<NewsDTO> getDtoClass() {
        return NewsDTO.class;
    }

    @Override
    protected XmEntityType getXmEntityType() {
        return XmEntityType.NEWS;
    }
}
