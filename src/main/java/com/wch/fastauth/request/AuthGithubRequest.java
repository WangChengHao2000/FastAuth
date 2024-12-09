package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.enums.AuthPlatformURL;

public class AuthGithubRequest extends AuthRequest{

    public AuthGithubRequest(AuthInfo authInfo) {
        super(authInfo, AuthPlatformURL.GITHUB);
    }

}
