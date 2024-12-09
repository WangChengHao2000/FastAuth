package com.wch.fastauth.utils;

import com.wch.fastauth.entity.enums.AuthScopeProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuthScopeUtils {

    public static List<String> getDefaultScopes(AuthScopeProvider[] scopes) {
        if (scopes == null || scopes.length == 0) {
            return null;
        }
        return Arrays.stream(scopes)
                .filter((AuthScopeProvider::isDefault))
                .map(AuthScopeProvider::getScope)
                .collect(Collectors.toList());
    }

    public static List<String> getScopes(AuthScopeProvider[] scopes) {
        if (scopes == null || scopes.length == 0) {
            return null;
        }
        return Arrays.stream(scopes)
                .map(AuthScopeProvider::getScope)
                .collect(Collectors.toList());
    }
}
