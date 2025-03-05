package com.linsir.auth.modules.login.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.linsir.auth.modules.login.service.CaptchaService;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.service.UserService;
import com.linsir.core.code.ResultCode;
import com.linsir.core.mybatis.controller.BaseController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class AuthLoginController extends BaseController {

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
    @PostMapping("login")
    public R login(String username, String password) throws Exception {
           return exec(()->{
             User user = userService.loadUserByUsername(username,password);
             if(user!=null){
                 StpUtil.login(user.getId());
                 return JsonResult.OK();
             }
             else
             {
                 return JsonResult.FAIL_NO_PERMISSION("登陆失败");
             }
            });
    }


    /**
     * 获取当前会话是否已经登录，返回true=已登录，false=未登录
     * @description: isLogin
     * @date: 2025/2/21 19:17
     * @Auther: linsir
     */
    @GetMapping("isLogin")
    public R isLogin()
    {
        return exec(()->{
           return JsonResult.OK(StpUtil.isLogin());
        });
    }

    /**
     * // 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
     * @description: checkLogin
     * @date: 2025/2/21 18:54
     * @Auther: linsir
     */
    @GetMapping("checkLogin")
    public R checkLogin()
    {
       return exec(()->{
            StpUtil.checkLogin();
            return JsonResult.OK("已经是登陆状态");
        });

    }

    /**
     * 退出
     */
    @GetMapping("logout")
    public R logout(){
        return exec(()->{
            StpUtil.logout();
            return JsonResult.OK("退出");
        });
    }


    /**
     * 获取 登陆id
     * @return
     */
    @GetMapping
    public R getLoginId()
    {
        return exec(()->{
            return JsonResult.OK(StpUtil.getLoginIdAsLong());
        });
    }
}
