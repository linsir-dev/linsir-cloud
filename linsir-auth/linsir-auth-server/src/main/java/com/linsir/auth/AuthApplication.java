package com.linsir.auth;


import com.linsir.core.launch.LinsirApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description：AuthApplication
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/10 14:06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        LinsirApplication.run("linsir-auth-server", AuthApplication.class, args);
    }
}
