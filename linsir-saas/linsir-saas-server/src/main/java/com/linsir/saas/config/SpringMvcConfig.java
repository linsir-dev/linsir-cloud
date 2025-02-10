package com.linsir.saas.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：linsir
 * @date ：Created in 2022/4/18 13:13
 * @description：SaaS服务配置
 * @modified By：
 * @version: 0.0.1
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={
        "com.linsir","com.linsir.core.handler",
        "com.linsir.saas.modules.security.filter",
        "com.linsir.saas.modules.security.requesthandler"
})
@MapperScan(basePackages={"com.linsir.saas.modules.*.mapper","com.linsir.core.mapper","com.linsir.*.mapper"})
public class SpringMvcConfig {
}
