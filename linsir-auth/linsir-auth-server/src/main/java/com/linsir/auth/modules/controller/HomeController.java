package com.linsir.auth.modules.controller;


import cn.dev33.satoken.oauth2.template.SaOAuth2Util;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;

/**
 * description：HomeController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/10 14:34
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("getIndex")
    public String index() {
        return "Hello World! auth！！！" + StpUtil.getLoginIdAsString();
    }
}
