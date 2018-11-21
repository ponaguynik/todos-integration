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
public class ProjectStateDTO implements XmEntityDTO, Serializable {
    private static final long serialVersionUID = 1L;

    private Long stateId;
    private String stateNameUkr;
    private String stateNameEng;
    private String eventTypeCode;
}