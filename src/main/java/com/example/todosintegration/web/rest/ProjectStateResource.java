package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectStateDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project-states")
public class ProjectStateResource extends AbstractXmEntityDtoResource<ProjectStateDTO> {

    @Autowired
    public ProjectStateResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        super(xmEntityDtoService, xmEntityService);
    }

    @Override
    protected Class<ProjectStateDTO> getDtoClass() {
        return ProjectStateDTO.class;
    }

    @Override
    protected XmEntityType getXmEntityType() {
        return XmEntityType.PROJECT_STATE;
    }
}
