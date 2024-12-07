package com.wch.fastauth.entity.enums;

import com.wch.fastauth.exception.AuthException;

public interface AuthURL {

    String authorize();

    String accessToken();

    String userInfo();

    default String revoke() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    default String refresh() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

}
