package com.wch.fastauth.entity.enums;

import com.wch.fastauth.exception.AuthException;
import com.wch.fastauth.request.AuthRequest;
import com.wch.fastauth.request.AuthRequestProvider;

public interface AuthPlatformURLProvider {

    String authorize();

    String accessToken();

    String userInfo();

    default String revoke() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    default String refresh() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    Class<? extends AuthRequestProvider> getTargetClass();

    default String getName() {
        if (this instanceof Enum) {
            return String.valueOf(this);
        }
        return this.getClass().getSimpleName();
    }
}
