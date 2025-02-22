package com.linsir.gateway.config;


import com.linsir.gateway.filter.GlobalRequestLogFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：Gatewayconfigue
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/10 16:20
 */
@Configuration
@MapperScan(basePackages={"com.linsir.core.mybatis.mapper"})
public class GatewayConfiguration {


}
