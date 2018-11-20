package com.example.todosintegration.client;

import com.example.todosintegration.client.config.UaaClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.todosintegration.client.UaaClient.SERVICE_NAME;

@FeignClient(name = SERVICE_NAME, url = "${services." + SERVICE_NAME + ".url}/" + SERVICE_NAME,
        configuration = UaaClientConfiguration.class)
public interface UaaClient {
    String SERVICE_NAME = "uaa";
    String DEFAULT_CLIENT_CREDENTIALS = "client_credentials";

    @PostMapping(path = "/oauth/token")
    String getToken(@RequestParam(name = "grant_type", defaultValue = DEFAULT_CLIENT_CREDENTIALS) String grantType);
}
