package com.wch.fastauth.entity.enums;

import com.wch.fastauth.request.AuthGiteeRequest;
import com.wch.fastauth.request.AuthGithubRequest;
import com.wch.fastauth.request.AuthRequestProvider;

public enum AuthPlatformURL implements AuthPlatformURLProvider {
    GITHUB {
        @Override
        public String authorize() {
            return "https://github.com/login/oauth/authorize";
        }

        @Override
        public String accessToken() {
            return "https://github.com/login/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.github.com/user";
        }

        @Override
        public Class<? extends AuthRequestProvider> getTargetClass() {
            return AuthGithubRequest.class;
        }
    },
    GITEE {
        @Override
        public String authorize() {
            return "https://gitee.com/oauth/authorize";
        }

        @Override
        public String accessToken() {
            return "https://gitee.com/oauth/token";
        }

        @Override
        public String userInfo() {
            return "https://gitee.com/api/v5/user";
        }

        @Override
        public Class<? extends AuthRequestProvider> getTargetClass() {
            return AuthGiteeRequest.class;
        }
    },
}
