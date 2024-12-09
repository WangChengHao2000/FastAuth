package com.wch.fastauth.entity;

import com.wch.fastauth.entity.enums.AuthResponseStatus;
import lombok.*;

import java.io.Serializable;

/**
 * JustAuth统一授权响应类
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @since 1.8
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public boolean ok() {
        return this.code == AuthResponseStatus.SUCCESS.getCode();
    }

}
