package com.wch.fastauth.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class URLBuilder {

    private String baseURL;
    private final Map<String, String> paramMap = new LinkedHashMap<>();


    private URLBuilder() {

    }

    public static URLBuilder baseURL(String baseURL) {
        URLBuilder builder = new URLBuilder();
        builder.setBaseURL(baseURL);
        return builder;
    }

    public URLBuilder queryParam(String key, String value) {
        this.paramMap.put(key, value);
        return this;
    }

    public String build() {
        return this.baseURL + "?" + parseMapToParamString(this.paramMap);
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    private String parseMapToParamString(Map<String, String> paramMap) {
        List<String> paramList = new ArrayList<>();
        paramMap.forEach((key, value) -> paramList.add(key + "=" + value));
        return String.join("&", paramList);
    }
}
