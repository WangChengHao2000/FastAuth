package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.enums.AuthURLProvider;
import com.wch.fastauth.utils.URLBuilder;

public class AuthGiteeRequest {

    private AuthInfo authInfo;

    private AuthURLProvider authURLProvider;

    public String authorize(String state) {
        return URLBuilder.baseURL(authURLProvider.authorize())
                .queryParam("response_type", "code")
                .queryParam("client_id", authInfo.getClientId())
                .queryParam("redirect_uri", authInfo.getRedirectUri())
                .queryParam("state", state)
                .build();
    }

}
