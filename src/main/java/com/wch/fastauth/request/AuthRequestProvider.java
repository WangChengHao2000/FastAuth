package com.wch.fastauth.request;

import com.wch.fastauth.entity.enums.AuthResponseStatus;
import com.wch.fastauth.exception.AuthException;

public interface AuthRequestProvider {

    default String authorize() {
        throw new AuthException(AuthResponseStatus.NOT_IMPLEMENTED);
    }

}
