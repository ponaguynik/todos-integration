package com.example.todosintegration.web.rest;

import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.ProjectEventTypeDTO;
import com.example.todosintegration.service.XmEntityDtoService;
import com.example.todosintegration.service.XmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project-event-types")
public class ProjectEventTypeResource extends AbstractXmEntityDtoResource<ProjectEventTypeDTO> {

    @Autowired
    public ProjectEventTypeResource(XmEntityDtoService xmEntityDtoService, XmEntityService xmEntityService) {
        super(xmEntityDtoService, xmEntityService);
    }

    @Override
    protected Class<ProjectEventTypeDTO> getDtoClass() {
        return ProjectEventTypeDTO.class;
    }

    @Override
    protected XmEntityType getXmEntityType() {
        return XmEntityType.PROJECT_EVENT_TYPE;
    }
}
