package com.wch.fastauth.controller;

import com.wch.fastauth.request.AuthRequestBuilder;
import com.wch.fastauth.entity.AuthCallback;
import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.enums.scope.AuthGiteeScope;
import com.wch.fastauth.request.AuthRequestProvider;
import com.wch.fastauth.utils.AuthScopeUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    @GetMapping("/render/{platform}")
    public void render(@PathVariable("platform") String platform, HttpServletResponse response)
            throws IOException {
        AuthRequestProvider authRequest = AuthRequestBuilder.builder()
                .platform(platform)
                .authInfo(AuthInfo.builder().clientId("9acea40c71f75843ccf4396cab33705a65716f4a12e76a87f5b36f3807ac086e")
                        .clientSecret("ae9a2650809f32f302cdbb99d98c2f4843a63e2d9b536cdfd3814cb7edcbe8f6")
                        .redirectUri("http://127.0.0.1:8041/oauth/callback/gitee")
                        .scopes(AuthScopeUtils.getDefaultScopes(AuthGiteeScope.values()))
                        .build())
                .build();
        String authorizeURL = authRequest.authorize();
        System.out.println(authorizeURL);
        response.sendRedirect(authorizeURL);
    }

    @RequestMapping("/callback/{source}")
    public String login(@PathVariable("source") String source, AuthCallback callback) {
        return callback.getCode();
    }

}
