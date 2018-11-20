package com.example.todosintegration.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtToken {
    // JSON names of fields
    public static final String ACCESS_TOKEN_FIELD = "access_token";
    public static final String TOKEN_TYPE_FIELD = "token_type";
    public static final String EXPIRES_IN_FIELD = "expires_in";
    public static final String SCOPE_FIELD = "scope";
    public static final String TENANT_FIELD = "tenant";
    public static final String JTI_FIELD = "jti";

    private final String accessToken;
    private final String tokenType;
    private final long expiresId;
    private final String scope;
    private final String tenant;
    private final String jti;

    @JsonCreator
    public JwtToken(@JsonProperty(ACCESS_TOKEN_FIELD) String accessToken,
                    @JsonProperty(TOKEN_TYPE_FIELD) String tokenType,
                    @JsonProperty(EXPIRES_IN_FIELD) long expiresId,
                    @JsonProperty(SCOPE_FIELD) String scope,
                    @JsonProperty(TENANT_FIELD) String tenant,
                    @JsonProperty(JTI_FIELD) String jti) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresId = expiresId;
        this.scope = scope;
        this.tenant = tenant;
        this.jti = jti;
    }
}
