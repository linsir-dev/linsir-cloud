package com.linsir.auth.modules.oauth2.controller;


import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.processor.SaOAuth2ServerProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：SaOAuth2ServerController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/22 2:08
 */
@RestController
public class SaOAuth2ServerController {

    // OAuth2-Server 端：处理所有 OAuth2 相关请求
    @RequestMapping("/oauth2/*")
    public Object request() {
        System.out.println("------- 进入请求: " + SaHolder.getRequest().getUrl());
        return SaOAuth2ServerProcessor.instance.dister();
    }

}
