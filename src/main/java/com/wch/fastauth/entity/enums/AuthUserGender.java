package com.wch.fastauth.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@Getter
@AllArgsConstructor
public enum AuthUserGender {

    MALE("1", "男"),
    FEMALE("0", "女"),
    UNKNOWN("-1", "未知");

    private String code;
    private String desc;

    public static AuthUserGender getRealGender(String originalGender) {
        if (originalGender == null || UNKNOWN.getCode().equals(originalGender)) {
            return UNKNOWN;
        }
        String[] males = {"m", "男", "1", "male"};
        if (Arrays.asList(males).contains(originalGender.toLowerCase())) {
            return MALE;
        }
        return FEMALE;
    }

}
