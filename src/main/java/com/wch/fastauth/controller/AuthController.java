package com.wch.fastauth.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    @GetMapping("/render/gitee")
    public void getGiteeCode(HttpServletResponse response) throws IOException {

    }

}
