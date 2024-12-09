package com.wch.fastauth.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthCallback implements Serializable {
    private String code;
    private String state;
}
