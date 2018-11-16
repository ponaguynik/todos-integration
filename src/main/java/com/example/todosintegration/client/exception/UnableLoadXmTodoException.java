package com.example.todosintegration.client.exception;

public class UnableLoadXmTodoException extends RuntimeException {

    public UnableLoadXmTodoException(String message) {
        super(message);
    }

    public UnableLoadXmTodoException(String message, Throwable cause) {
        super(message, cause);
    }
}
