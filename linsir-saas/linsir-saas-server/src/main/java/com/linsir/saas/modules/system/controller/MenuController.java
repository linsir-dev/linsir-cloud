package com.linsir.saas.modules.system.controller;


import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.oauth2.SaOAuth2Manager;
import cn.dev33.satoken.oauth2.data.model.AccessTokenModel;
import cn.dev33.satoken.oauth2.template.SaOAuth2Util;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.linsir.core.mybatis.controller.BaseController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.impl.SysResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 菜单
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 11:53:27
 */
@RestController
@RequestMapping("/v1/menu/")
public class MenuController extends BaseController {

    @Autowired
    private SysResourceServiceImpl sysResourceService;

    /**
     * 超级管理员 菜单
     * @return
     */
    @GetMapping("/getByUser")
    public Object getByUser(){
        SaRequest reque = SaHolder.getRequest();
        String accessToken = SaOAuth2Manager.getDataResolver().readAccessToken(SaHolder.getRequest());
        AccessTokenModel a = SaOAuth2Util.getAccessToken(accessToken);
        Object ab = SaOAuth2Util.getLoginIdByAccessToken(accessToken);
        return accessToken;
    }

}
