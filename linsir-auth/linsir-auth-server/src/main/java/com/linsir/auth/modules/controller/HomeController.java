package com.linsir.auth.modules.controller;


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

    @GetMapping("")
    public String index() {
        return "Hello World! auth";
    }
}
