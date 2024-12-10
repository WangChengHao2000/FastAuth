package com.wch.fastauth.request;

import com.alibaba.fastjson.JSONObject;
import com.wch.fastauth.entity.AuthCallback;
import com.wch.fastauth.entity.AuthInfo;
import com.wch.fastauth.entity.AuthToken;
import com.wch.fastauth.entity.AuthUser;
import com.wch.fastauth.entity.enums.AuthPlatformURL;
import com.wch.fastauth.entity.enums.AuthUserGender;
import com.wch.fastauth.entity.enums.scope.AuthGiteeScope;
import com.wch.fastauth.utils.AuthScopeUtils;
import com.wch.fastauth.utils.URLBuilder;

public class AuthGiteeRequest extends AuthRequest {

    public AuthGiteeRequest(AuthInfo authInfo) {
        super(authInfo, AuthPlatformURL.GITEE);
    }

    @Override
    public String authorizeURL() {
        return URLBuilder.baseURL(super.authorizeURL())
                .queryParam("scope", this.getScopes(AuthScopeUtils.getDefaultScopes(AuthGiteeScope.values()), true))
                .build();
    }

    @Override
    protected AuthToken getAccessToken(AuthCallback authCallback) {
        String response = doPostAuthorizationCode(authCallback.getCode());
        JSONObject accessTokenObject = JSONObject.parseObject(response);
        return AuthToken.builder()
                .accessToken(accessTokenObject.getString("access_token"))
                .refreshToken(accessTokenObject.getString("refresh_token"))
                .scope(accessTokenObject.getString("scope"))
                .tokenType(accessTokenObject.getString("token_type"))
                .expireIn(accessTokenObject.getIntValue("expires_in"))
                .build();
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String userInfo = doGetUserInfo(authToken);
        JSONObject object = JSONObject.parseObject(userInfo);
        return AuthUser.builder()
                .rawUserInfo(object)
                .uuid(object.getString("id"))
                .username(object.getString("login"))
                .avatar(object.getString("avatar_url"))
                .blog(object.getString("blog"))
                .nickname(object.getString("name"))
                .company(object.getString("company"))
                .location(object.getString("address"))
                .email(object.getString("email"))
                .remark(object.getString("bio"))
                .gender(AuthUserGender.UNKNOWN)
                .token(authToken)
                .source(authPlatformURLProvider.toString())
                .build();
    }
}
