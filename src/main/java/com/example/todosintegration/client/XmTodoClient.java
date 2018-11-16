package com.example.todosintegration.client;

import com.example.todosintegration.client.exception.UnableLoadXmTodoException;
import com.example.todosintegration.domain.XmTodo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// TODO: 16-Nov-18 consider using FeignClient instead of RestTemplate
@Slf4j
@Component
public class XmTodoClient {
    private final RestTemplate restTemplate;

    @Autowired
    public XmTodoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<XmTodo> loadAllByUrl(String url) {
        try {
            ResponseEntity<List<XmTodo>> rateResponse =
                    restTemplate.exchange(url,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<XmTodo>>() {
                            });
            return rateResponse.getBody();
        } catch (RestClientException e) {
            throw new UnableLoadXmTodoException("Failed to load XmTodos by URL : " + url, e);
        }
    }
}
