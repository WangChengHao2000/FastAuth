package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.enums.AuthPlatformURLProvider;
import com.wch.fastauth.utils.URLBuilder;
import com.wch.fastauth.utils.URLUtils;
import com.wch.fastauth.utils.UuidUtils;

import java.util.List;

public class AuthRequest implements AuthRequestProvider {

    private final AuthInfo authInfo;
    private final AuthPlatformURLProvider authPlatformURLProvider;

    private String state;

    public AuthRequest(AuthInfo authInfo, AuthPlatformURLProvider authPlatformURLProvider) {
        this.authInfo = authInfo;
        this.authPlatformURLProvider = authPlatformURLProvider;
    }

    @Override
    public String authorize() {
        state = UuidUtils.getUUID();
        return URLBuilder.baseURL(authPlatformURLProvider.authorize())
                .queryParam("response_type", "code")
                .queryParam("client_id", authInfo.getClientId())
                .queryParam("redirect_uri", authInfo.getRedirectUri())
                .queryParam("state", state)
                .build();
    }

    protected String getScopes(List<String> defaultScopes, boolean encode) {
        List<String> scopes = authInfo.getScopes();
        if (scopes == null || scopes.isEmpty()) {
            if (defaultScopes == null || defaultScopes.isEmpty()) {
                return "";
            }
            scopes = defaultScopes;
        }
        String scopeString = String.join(" ", scopes);
        return encode ? URLUtils.URLEncode(scopeString) : scopeString;
    }
}

