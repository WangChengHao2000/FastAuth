package com.wch.fastauth.entity;

import com.alibaba.fastjson.JSONObject;
import com.wch.fastauth.entity.enums.AuthUserGender;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser implements Serializable {

    private String uuid;
    private String username;
    private String nickname;
    private String avatar;
    private String blog;
    private String company;
    private String location;
    private String email;
    private String remark;
    private AuthUserGender gender;
    private String source;
    private AuthToken token;
    private JSONObject rawUserInfo;

}
