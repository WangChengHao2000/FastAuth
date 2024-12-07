package com.wch.fastauth.controller;

import com.wch.fastauth.entity.AuthGiteeInfo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private AuthGiteeInfo authGiteeInfo;

    @GetMapping("/render/gitee")
    public void getGiteeCode(HttpServletResponse response) throws IOException {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        String url = authGiteeInfo.getAuthorizeURL() +
                "?response_type=code" +
                "&client_id=" + authGiteeInfo.getAppID() +
                "&redirect_uri=" + authGiteeInfo.getRedirectURI() +
                "&state=" + uuid +
                "&scope=user_info";

        // response.sendRedirect(url);
        System.out.println(uuid);
        System.out.println(url);
    }

}
