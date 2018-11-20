package com.example.todosintegration.service.mapper.exception;

public class MapperNotFoundException extends RuntimeException {

    public MapperNotFoundException() {
    }

    public MapperNotFoundException(String message) {
        super(message);
    }
}
