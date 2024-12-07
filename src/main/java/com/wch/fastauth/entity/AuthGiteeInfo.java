package com.wch.fastauth.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:application.properties")
public class AuthGiteeInfo {

    @Value("${gitee.appId}")
    private String appID;

    @Value("${gitee.appKey}")
    private String appKEY;

    @Value("${gitee.redirectUrl}")
    private String redirectURI;

    @Value("${gitee.authorizeUrl}")
    private String authorizeURL;

    @Value("${gitee.accessToken}")
    private String accessToken;

    @Value("${gitee.userInfo}")
    private String userInfo;

}
