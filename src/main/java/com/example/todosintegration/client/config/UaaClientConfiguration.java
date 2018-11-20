package com.example.todosintegration.client.config;

import com.example.todosintegration.config.properties.ServiceConfigurationProperties;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import static com.example.todosintegration.client.UaaClient.SERVICE_NAME;

public class UaaClientConfiguration {
    private final ServiceConfigurationProperties serviceConfig;

    @Autowired
    public UaaClientConfiguration(ServiceConfigurationProperties serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        ServiceConfigurationProperties.Service service = serviceConfig.getServices().get(SERVICE_NAME);
        if (service != null && service.getLogin() != null && service.getPassword() != null) {
            return new BasicAuthRequestInterceptor(service.getLogin(), service.getPassword());
        }
        throw new IllegalStateException("BasicAuthRequestInterceptor is declared for service " + SERVICE_NAME + " but no credentials provided");
    }

//    @Bean
//    public Logger.Level loggerLevel() {
//        return Logger.Level.FULL;
//    }
}
