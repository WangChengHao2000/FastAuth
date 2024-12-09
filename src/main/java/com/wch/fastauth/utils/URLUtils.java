package com.wch.fastauth.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLUtils {

    public static String URLEncode(String URL) {
        if (URL == null) {
            return "";
        } else {
            try {
                String encoded = URLEncoder.encode(URL, StandardCharsets.UTF_8.displayName());
                return encoded.replace("+", "%20").replace("*", "%2A").replace("~", "%7E").replace("/", "%2F");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
