package com.linsir.auth.modules.login.dto;


import lombok.Builder;
import lombok.Data;

/**
 * description：CaptchaResult
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/13 20:28
 */
@Builder
@Data
public class CaptchaResult {

    private String captchaKey;

    private String captchaBase64;
}
