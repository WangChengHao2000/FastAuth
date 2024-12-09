package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthCallback;
import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.AuthToken;
import com.wch.fastauth.entity.AuthUser;
import com.wch.fastauth.entity.enums.AuthPlatformURL;

public class AuthGithubRequest extends AuthRequest{

    public AuthGithubRequest(AuthInfo authInfo) {
        super(authInfo, AuthPlatformURL.GITHUB);
    }

    @Override
    protected AuthToken getAccessToken(AuthCallback authCallback) {
        return null;
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        return null;
    }
}
