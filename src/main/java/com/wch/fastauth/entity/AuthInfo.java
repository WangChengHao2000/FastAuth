package com.wch.fastauth.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfo {

    private String clientId;
    private String clientSecret;
    private String redirectUri;

}
