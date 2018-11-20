package com.example.todosintegration.exception;

public class UnableLoadXmEntityException extends RuntimeException {

    public UnableLoadXmEntityException(String message) {
        super(message);
    }

    public UnableLoadXmEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableLoadXmEntityException(Throwable cause) {
        super(cause);
    }
}
