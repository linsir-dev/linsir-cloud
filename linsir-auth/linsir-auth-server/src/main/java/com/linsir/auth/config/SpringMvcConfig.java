package com.linsir.auth.config;

import com.linsir.core.mybatis.data.protect.DataEncryptHandler;
import com.linsir.core.mybatis.data.protect.DataMaskHandler;
import com.linsir.core.mybatis.data.protect.DefaultDataEncryptHandler;
import com.linsir.core.mybatis.data.protect.DefaultDataMaskHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
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
@ComponentScan(basePackages = "com.linsir")
@MapperScan(basePackages={"com.linsir.auth.modules.*.mapper","com.linsir.core.mybatis.mapper"})
public class SpringMvcConfig {

    /**
     * 字典等基础数据缓存管理器
     *
     * @return
     */

    /**
     * 在自定义的加解密实现类上使用Spring注解实例化
     */
    @Bean
    public DataEncryptHandler dataEncryptHandler() {
        return new DefaultDataEncryptHandler();
    }


    /**
     *
     * * 在Spring配置类中实例化DataMaskHandler 数据脱敏展示处理器
     * @return
     */
    @Bean
    public DataMaskHandler dataMaskHandler() {
        return new DefaultDataMaskHandler();
    }
}
