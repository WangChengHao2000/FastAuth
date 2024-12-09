package com.wch.fastauth.request;

import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.enums.AuthPlatformURL;
import com.wch.fastauth.entity.enums.scope.AuthGiteeScope;
import com.wch.fastauth.utils.AuthScopeUtils;
import com.wch.fastauth.utils.URLBuilder;

public class AuthGiteeRequest extends AuthRequest {

    public AuthGiteeRequest(AuthInfo authInfo) {
        super(authInfo, AuthPlatformURL.GITEE);
    }

    @Override
    public String authorize() {
        return URLBuilder.baseURL(super.authorize())
                .queryParam("scope", this.getScopes(AuthScopeUtils.getDefaultScopes(AuthGiteeScope.values()), true))
                .build();
    }
}
