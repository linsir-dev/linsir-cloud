package com.linsir.saas.config;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan(basePackages={"com.linsir.saas.modules.*.mapper"})
public class SpringMvcConfig {
}
