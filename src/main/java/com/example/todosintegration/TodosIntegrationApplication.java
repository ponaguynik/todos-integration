package com.example.todosintegration;

import com.example.todosintegration.config.properties.ServiceConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(ServiceConfigurationProperties.class)
public class TodosIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosIntegrationApplication.class, args);
    }
}
