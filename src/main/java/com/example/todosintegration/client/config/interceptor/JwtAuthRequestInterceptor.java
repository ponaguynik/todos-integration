package com.example.todosintegration.client.config.interceptor;

import com.example.todosintegration.util.JwtTokenUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

import java.util.function.Supplier;

// TODO: 20-Nov-18 reuse auth token
@Slf4j
public class JwtAuthRequestInterceptor implements RequestInterceptor {
    private final Supplier<String> jwtTokenSupplier;

    public JwtAuthRequestInterceptor(Supplier<String> jwtTokenSupplier) {
        this.jwtTokenSupplier = jwtTokenSupplier;
    }

    @Override
    public void apply(RequestTemplate template) {
        try {
            String accessToken = JwtTokenUtils.withBearer(getAccessToken());
            addAuthHeader(accessToken, template);
            log.debug("Added '{}: {}' header", HttpHeaders.AUTHORIZATION, accessToken);
        } catch (Exception e) {
            log.error("Unable to request access token", e);
        }
    }

    private String getAccessToken() {
        return JwtTokenUtils.parseJwtToken(jwtTokenSupplier.get()).getAccessToken();
    }

    private void addAuthHeader(String accessToken, RequestTemplate template) {
        template.header(HttpHeaders.AUTHORIZATION, accessToken);
    }
}
