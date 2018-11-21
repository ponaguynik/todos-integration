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
public class ResponsibleExecutorDTO implements XmEntityDTO, Serializable {
    private static final long serialVersionUID = 1L;

    private Long responsibleExecutorId;
    private String responsibleExecutorNameUkr;
    private String responsibleExecutorNameEng;
}
