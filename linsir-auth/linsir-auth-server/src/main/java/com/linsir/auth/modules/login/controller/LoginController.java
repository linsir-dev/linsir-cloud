package com.linsir.auth.modules.login.controller;


import com.linsir.auth.modules.login.service.CaptchaService;
import com.linsir.auth.modules.rabc.service.UserService;
import com.linsir.core.mybatis.controller.BaseController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：LoginController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/18 14:22
 */

@RestController
@RequestMapping("/")
public class LoginController extends BaseController {

    @Resource
    private CaptchaService captchaService;

    @Autowired
    private UserService userService;

    /**
     * 验证码
     * @return
     * @throws Exception
     */
    @GetMapping("captcha")
    public R captcha() throws Exception {
        return exec(2,()->{
            return JsonResult.OK(captchaService.getCaptcha());
        });
    }

    /**
     * 用户米密码登陆
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public R login(String username, String password) throws Exception {
            return null;
    }
}
