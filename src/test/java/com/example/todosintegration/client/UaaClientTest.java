package com.example.todosintegration.client;

import com.example.todosintegration.util.JwtToken;
import com.example.todosintegration.util.JwtTokenUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import static org.junit.Assert.assertNotNull;

@Profile("test-uaa")
public class UaaClientTest extends FeignClientAbstractTest {
    @Autowired
    private UaaClient uaaClient;

    @Test
    public void testGetAndParseJwtToken() {
        String token = uaaClient.getToken(UaaClient.DEFAULT_CLIENT_CREDENTIALS);
        JwtToken jwtToken = JwtTokenUtils.parseJwtToken(token);

        assertNotNull(jwtToken);
        assertNotNull(jwtToken.getAccessToken());
        assertNotNull(jwtToken.getJti());
        assertNotNull(jwtToken.getScope());
        assertNotNull(jwtToken.getTenant());
        assertNotNull(jwtToken.getTokenType());
    }
}