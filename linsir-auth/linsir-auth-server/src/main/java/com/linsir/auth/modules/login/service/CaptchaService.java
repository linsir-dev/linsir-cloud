package com.linsir.auth.modules.login.service;


import com.linsir.auth.modules.login.dto.CaptchaResult;
import com.linsir.auth.props.CaptchaProperties;

/**
 * @author linsir
 * @version 1.0.0
 * @title CaptchaService
 * @description
 * @create 2024/7/22 23:17
 */


public interface CaptchaService {

   CaptchaResult getCaptcha();

   CaptchaResult getCaptcha(CaptchaProperties captchaProperties);

   boolean checkCaptcha(String captchaKey,String captchaCode);
}
