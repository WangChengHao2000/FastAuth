package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.enums.AuthPlatformURL;
import com.wch.fastauth.entity.enums.AuthPlatformURLProvider;
import com.wch.fastauth.entity.enums.AuthResponseStatus;
import com.wch.fastauth.exception.AuthException;

import java.util.Arrays;

public class AuthRequestBuilder {

    private String authPlatform;
    private AuthInfo authInfo;

    private AuthRequestBuilder() {

    }

    public static AuthRequestBuilder builder() {
        return new AuthRequestBuilder();
    }

    public AuthRequestBuilder platform(String authPlatform) {
        this.authPlatform = authPlatform;
        return this;
    }

    public AuthRequestBuilder authInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
        return this;
    }

    public AuthRequestProvider build() {
        AuthPlatformURLProvider[] authPlatformList = AuthPlatformURL.values();
        AuthPlatformURLProvider authPlatformClass = Arrays.stream(authPlatformList)
                .filter(clz -> clz.getName().equalsIgnoreCase(this.authPlatform))
                .findAny()
                .orElseThrow(() -> new AuthException(AuthResponseStatus.NOT_IMPLEMENTED));
        Class<? extends AuthRequestProvider> targetClass = authPlatformClass.getTargetClass();
        try {
            return targetClass.getDeclaredConstructor(AuthInfo.class).newInstance(this.authInfo);
        } catch (Exception e) {
            throw new AuthException(AuthResponseStatus.NOT_IMPLEMENTED);
        }
    }

}
