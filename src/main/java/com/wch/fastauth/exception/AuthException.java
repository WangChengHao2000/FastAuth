package com.wch.fastauth.exception;

import com.wch.fastauth.entity.enums.AuthResponseStatus;

public class AuthException extends RuntimeException {

    private final int errorCode;
    private final String errorMsg;

    public AuthException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AuthException(AuthResponseStatus status) {
        this(status.getCode(), status.getMsg());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
