package com.linsir.gateway.config;


import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * description：SaTokenConfigure
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/3/3 9:34
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")    /* 拦截全部path */
                // 开放地址
                .addExclude("/favicon.ico")

                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                    SaRouter.match("/**").notMatch("/notLogin",
                            "/linsir-auth-server",
                            "/linsir-auth-server/oauth2/**",
                            "/linsir-saas-server/**").check(StpUtil::checkLogin);
                    SaRouter.match("/index").check(saRouterStaff -> StpUtil.checkPermission("user"));
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {

                    if (e instanceof NotLoginException) {

                        NotLoginException nle = NotLoginException.class.cast(e);
                        // 打印堆栈，以供调试
                       // nle.printStackTrace();

                        // 判断场景值，定制化异常信息
                        String message = "";
                        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
                            message = "未能读取到有效 token";
                        }
                        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
                            message = "token 无效";
                        }
                        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
                            message = "token 已过期";
                        }
                        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
                            message = "token 已被顶下线";
                        }
                        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
                            message = "token 已被踢下线";
                        }
                        else if(nle.getType().equals(NotLoginException.TOKEN_FREEZE)) {
                            message = "token 已被冻结";
                        }
                        else if(nle.getType().equals(NotLoginException.NO_PREFIX)) {
                            message = "未按照指定前缀提交 token";
                        }
                        else {
                            message = "当前会话未登录";
                        }

                        // 返回给前端
                        return SaResult.error(message);
                    }

                    return SaResult.error(e.getMessage());
                })
                ;
    }
}
