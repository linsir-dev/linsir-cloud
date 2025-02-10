package com.linsir.gateway.config;


import com.linsir.gateway.filter.GlobalRequestLogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：Gatewayconfigue
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/10 16:20
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public GlobalRequestLogFilter globalRequestLogFilter() {
        return new GlobalRequestLogFilter();
    }
}
