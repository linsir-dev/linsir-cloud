package com.linsir.gateway.controller;


import com.linsir.core.results.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：GatewayController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/8 14:20
 */
@RestController("/")
public class GatewayController {

    @GetMapping("index")
    public String index() {
       return "Hello World!";
    }


    @GetMapping("notLogin")
    public String notLogin() {
        return "不需要登陆的";
    }

}
