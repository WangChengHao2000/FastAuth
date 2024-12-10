package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthHttpResponse;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpRequest {

    @Resource
    private RestTemplate restTemplate;

    public AuthHttpResponse post(String URL) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<HttpHeaders> request = new HttpEntity<>(requestHeaders);
        ResponseEntity<AuthHttpResponse> response = restTemplate.postForEntity(URL, request, AuthHttpResponse.class);
        return response.getBody();
    }

    public AuthHttpResponse get(String URL) {
        ResponseEntity<AuthHttpResponse> response = restTemplate.getForEntity(URL, AuthHttpResponse.class);
        return response.getBody();
    }

}
