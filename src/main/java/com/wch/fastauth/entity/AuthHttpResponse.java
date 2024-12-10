package com.wch.fastauth.entity;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthHttpResponse {

    private boolean success;
    private int code;
    private Map<String, List<String>> headers;
    private String body;
    private String error;

}
