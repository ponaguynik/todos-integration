package com.example.todosintegration.service.mapper.exception;

public class MappingFailedException extends RuntimeException {

    public MappingFailedException() {
    }

    public MappingFailedException(Throwable cause) {
        super(cause);
    }

    public MappingFailedException(String message) {
        super(message);
    }

    public MappingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
