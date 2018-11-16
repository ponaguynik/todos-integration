package com.example.todosintegration.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class XmTodo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
