package com.wch.fastauth.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfo {

    private String clientId;
    private String clientSecret;
    private String redirectUri;

    private List<String> scopes;

}
