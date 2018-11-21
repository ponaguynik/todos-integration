package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectFieldDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project-fields")
public class ProjectFieldResource extends AbstractXmEntityDtoResource<ProjectFieldDTO> {

    @Autowired
    public ProjectFieldResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        super(xmEntityDtoService, xmEntityService);
    }

    @Override
    protected Class<ProjectFieldDTO> getDtoClass() {
        return ProjectFieldDTO.class;
    }

    @Override
    protected XmEntityType getXmEntityType() {
        return XmEntityType.PROJECT_FIELD;
    }
}
