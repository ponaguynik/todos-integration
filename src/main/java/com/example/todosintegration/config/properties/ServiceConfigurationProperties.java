package com.example.todosintegration.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties
public class ServiceConfigurationProperties {
    private Map<String, Service> services = new HashMap<>();

    @Data
    public static class Service {
        private String url;
        private String login;
        private String password;
    }
}
