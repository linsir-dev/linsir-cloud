package com.linsir.saas.modules.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * *******************************************************
 * <p>
 * v2 版本的菜单控制  *
 * ******************************************************
 *
 * @author: linsir
 * @version: 0.0.1  *
 * @date: 2023/4/12 13:47
 */
@RestController
@RequestMapping("v2/menu/")
public class MenuV2Controller /*extends BaseController */{

   /* @Autowired
    private SysResourceServiceImpl sysResourceService;*/

    /**
     * 获取菜单
     * @param userId
     * @return
     * @throws Exception
     */
   /* @GetMapping("get/{userId}")
    public R getByUserId(@PathVariable("userId") Long userId) throws Exception {
        R result = null;
        result = exec("根据用户id获取菜单",()->{
            MenuVO menuVO = sysResourceService.getByUser(userId);
            return Result.SUCCESS(menuVO);
        });
        return  result;
    }*/


}
