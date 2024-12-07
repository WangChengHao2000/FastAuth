package com.wch.fastauth.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * JustAuth通用的状态码对照表
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @since 1.8
 */
@Getter
@AllArgsConstructor
public enum AuthResponseStatus {

    SUCCESS(200, "Success"),
    FAILURE(5000, "Failure"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    PARAMETER_INCOMPLETE(502, "Parameter incomplete"),
    UNSUPPORTED(503, "Unsupported operation"),
    NO_AUTH_SOURCE(504, "AuthDefaultSource cannot be null"),
    UNIDENTIFIED_PLATFORM(505, "Unidentified platform"),
    ILLEGAL_REDIRECT_URI(506, "Illegal redirect uri"),
    ILLEGAL_REQUEST(507, "Illegal request"),
    ILLEGAL_CODE(508, "Illegal code"),
    ILLEGAL_STATUS(509, "Illegal state"),
    REQUIRED_REFRESH_TOKEN(510, "The refresh token is required; it must not be null"),
    ILLEGAL_TOKEN(511, "Invalid token"),
    ILLEGAL_KID(512, "Invalid key identifier(kid)"),
    ILLEGAL_TEAM_ID(513, "Invalid team id"),
    ILLEGAL_CLIENT_ID(514, "Invalid client id"),
    ILLEGAL_CLIENT_SECRET(515, "Invalid client secret"),
    ;

    private final int code;
    private final String msg;
}

