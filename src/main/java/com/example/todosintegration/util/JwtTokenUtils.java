package com.example.todosintegration.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.UncheckedIOException;

@UtilityClass
public class JwtTokenUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static JwtToken parseJwtToken(String jwt) {
        try {
            return OBJECT_MAPPER.readValue(jwt, JwtToken.class);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String withBearer(String token) {
        return "Bearer " + token;
    }
}
