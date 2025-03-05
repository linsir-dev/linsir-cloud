package com.linsir.auth.modules.oauth2.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.linsir.core.mybatis.controller.BaseController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：TokenController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/3/3 19:44
 */
@RestController
@RequestMapping
public class TokenController extends BaseController {

    @GetMapping("getLoginIdByToken")
    public R getLoginIdByToken()
    {
        return exec(()->{
           return JsonResult.OK(  StpUtil.getLoginIdByToken(StpUtil.getLoginIdAsString()));
        });
    }
}
