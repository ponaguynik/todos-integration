package com.example.todosintegration.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEventTypeDTO implements XmEntityDTO, Serializable {
    private static final long serialVersionUID = 1L;

    private String eventTypeCode;
    private String eventTypeNameUkr;
    private String eventTypeNameEng;
}
