package com.linsir.auth.modules.login.dto;

import lombok.Data;

/**
 * @author linsir
 * @version 1.0.0
 * @title LoginParams
 * @description
 * @create 2024/7/28 18:55
 */

@Data
public class LoginParams {

    private String username;

    private String password;
}
