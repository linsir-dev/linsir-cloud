package com.linsir.auth.config;


import cn.dev33.satoken.oauth2.config.SaOAuth2ServerConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.service.UserService;
import com.linsir.core.mybatis.vo.JsonResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

/**
 * description：SaOAuth2ServerConfigure
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/3/5 20:40
 */
@Slf4j
@Configuration
public class SaOAuth2ServerConfigure {

    @Resource
    private UserService userService;


    public SaOAuth2ServerConfigure(SaOAuth2ServerConfig saOAuth2ServerConfig) {
        // 未登录的视图
        saOAuth2ServerConfig.notLoginView = ()->{
            return JsonResult.FAIL_NO_PERMISSION("未登录");
        };


        saOAuth2ServerConfig.doLoginHandle = (name,pwd)->{
            User user = userService.loadUserByUsername(name,pwd);
            if (user != null) {
                StpUtil.login(user.getId());
                log.info("------OauthServer 登陆成功-------");
                return SaResult.ok();
            }
            return SaResult.error();
        };
    }
}
