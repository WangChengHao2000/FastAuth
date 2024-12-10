package com.wch.fastauth.request;

import com.wch.fastauth.entity.*;
import com.wch.fastauth.entity.enums.AuthPlatformURLProvider;
import com.wch.fastauth.entity.enums.AuthResponseStatus;
import com.wch.fastauth.utils.URLBuilder;
import com.wch.fastauth.utils.URLUtils;
import com.wch.fastauth.utils.UuidUtils;

import java.util.List;

public abstract class AuthRequest implements AuthRequestProvider {

    protected final AuthInfo authInfo;
    protected final AuthPlatformURLProvider authPlatformURLProvider;

    private String state;

    public AuthRequest(AuthInfo authInfo, AuthPlatformURLProvider authPlatformURLProvider) {
        this.authInfo = authInfo;
        this.authPlatformURLProvider = authPlatformURLProvider;
    }

    @Override
    public String authorizeURL() {
        state = UuidUtils.getUUID();
        return URLBuilder.baseURL(authPlatformURLProvider.authorize())
                .queryParam("response_type", "code")
                .queryParam("client_id", authInfo.getClientId())
                .queryParam("redirect_uri", authInfo.getRedirectUri())
                .queryParam("state", state)
                .build();
    }

    protected String accessTokenURL(String code) {
        return URLBuilder.baseURL(authPlatformURLProvider.accessToken())
                .queryParam("code", code)
                .queryParam("client_id", authInfo.getClientId())
                .queryParam("client_secret", authInfo.getClientSecret())
                .queryParam("grant_type", "authorization_code")
                .queryParam("redirect_uri", authInfo.getRedirectUri())
                .build();
    }

    protected String userInfoURL(AuthToken authToken) {
        return URLBuilder.baseURL(authPlatformURLProvider.userInfo())
                .queryParam("access_token", authToken.getAccessToken())
                .build();
    }

    @Override
    public AuthResponse<?> login(AuthCallback authCallback) {
        AuthToken authToken = this.getAccessToken(authCallback);
        AuthUser user = this.getUserInfo(authToken);
        return AuthResponse.builder()
                .code(AuthResponseStatus.SUCCESS.getCode())
                .data(user)
                .build();
    }

    protected String doPostAuthorizationCode(String code) {
        String body = new HttpRequest().post(accessTokenURL(code)).getBody();
        System.out.println(body);
        return body;
    }

    protected String doGetAuthorizationCode(String code) {
        return null;
    }

    protected String doPostUserInfo(AuthToken authToken) {
        return null;
    }

    protected String doGetUserInfo(AuthToken authToken) {
        return null;
    }

    protected abstract AuthToken getAccessToken(AuthCallback authCallback);

    protected abstract AuthUser getUserInfo(AuthToken authToken);

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

