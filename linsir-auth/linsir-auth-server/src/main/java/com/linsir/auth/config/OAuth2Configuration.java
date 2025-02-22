package com.linsir.auth.config;


import cn.dev33.satoken.oauth2.config.SaOAuth2ServerConfig;
import cn.dev33.satoken.oauth2.function.SaOAuth2DoLoginHandleFunction;
import cn.dev33.satoken.oauth2.function.SaOAuth2NotLoginViewFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：OAuth2Configuration
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/22 2:06
 */
@Configuration
public class OAuth2Configuration {

    @Bean
    public SaOAuth2ServerConfig saOAuth2ServerConfig(){
        SaOAuth2ServerConfig saOAuth2ServerConfig = new SaOAuth2ServerConfig();
        saOAuth2ServerConfig.notLoginView = saOAuth2NotLoginViewFunction();
        saOAuth2ServerConfig.doLoginHandle = saOAuth2DoLoginHandleFunction();
        return saOAuth2ServerConfig;
    }

    @Bean
    public SaOAuth2NotLoginViewFunction saOAuth2NotLoginViewFunction(){
        return ()->{
            return "login";
        };
    }

    @Bean
    public SaOAuth2DoLoginHandleFunction saOAuth2DoLoginHandleFunction(){
        return (name,pwd)->{
            return "login";
        };
    }
}
