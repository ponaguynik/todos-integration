package com.example.todosintegration.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TodoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long code;
    private Long userCode;
    private String title;
    private boolean completed;
}
