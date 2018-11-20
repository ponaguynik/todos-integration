package com.example.todosintegration.client.config;

import com.example.todosintegration.client.UaaClient;
import com.example.todosintegration.client.config.interceptor.JwtAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class EntityClientConfiguration {

    @Bean
    public JwtAuthRequestInterceptor bearerAuthRequestInterceptor(UaaClient uaaClient) {
        return new JwtAuthRequestInterceptor(() -> uaaClient.getToken(UaaClient.DEFAULT_CLIENT_CREDENTIALS));
    }

    //    @Bean
//    public Logger.Level loggerLevel() {
//        return Logger.Level.FULL;
//    }
}