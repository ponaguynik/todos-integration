package com.example.todosintegration.client;

import com.example.todosintegration.client.config.EntityClientConfiguration;
import com.example.todosintegration.domain.XmEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.example.todosintegration.client.UaaClient.SERVICE_NAME;

@FeignClient(name = EntityClient.SERVICE_NAME, url = "${services." + SERVICE_NAME + ".url}/" + EntityClient.SERVICE_NAME,
        configuration = EntityClientConfiguration.class)
public interface EntityClient {
    String SERVICE_NAME = "entity";

    @GetMapping(path = "/api/xm-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<XmEntity> getAllXmEntitiesByTypeKey(@RequestParam("typeKey") String typeKey);
}
