package com.linsir.auth.modules.rabc.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.linsir.auth.modules.rabc.dto.AddRolesDTO;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.entity.UserRole;
import com.linsir.auth.modules.rabc.service.impl.UserServiceImpl;
import com.linsir.auth.modules.rabc.vo.UserVO;
import com.linsir.core.code.ResultCode;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.data.protect.DataEncryptHandler;
import com.linsir.core.mybatis.exception.BusinessException;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.mybatis.vo.Pagination;
import com.linsir.core.results.R;
import jakarta.activation.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:35:10
 */
@RestController
@RequestMapping("/user/")
public class UserController extends BaseCrudRestController<User> {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private DataEncryptHandler dataEncryptHandler;

     /**
      * 添加账号
      * @param user
      * @return
      */
     @PostMapping("add")
     public R add(@Validated User user) {
          return exec(()->{
             return createEntity(user);
          });
     }


     @DeleteMapping("del")
     public R del(Long id)
     {
         return exec(()->{
             return deleteEntity(id);
         });
     }

     @PostMapping("update")
     public R update(@Validated User user) {
         return exec(()->{
             return updateEntity(user.getId(),user);
         });
     }


     @GetMapping("get")
     public R get(Long id) {
         return  exec(()->{
             return JsonResult.OK(getEntity(id));
         });
     }


     @PostMapping("resetPassword")
     public R resetPassword(Long id) {
         return  exec(()->{
             UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
             updateWrapper.eq("id",id);
             updateWrapper.set("password",dataEncryptHandler.encrypt("123456"));
            return JsonResult.OK(getService().updateEntity(updateWrapper));
         });
     }


    /**
     * @description 获取用户
     * @author Linsir
     * @param
     * @return com.linsir.base.core.vo.results.R
     * @time 2024/8/10 0:58
     */
    /* @OperationLog(bizId = "#id",bizType = "'get'",msg = "'租户用户'")*/
     @GetMapping("getVO")
     public R getVO(Long id) {
         return  exec(()->{
             return getViewObject(id, UserVO.class);
         });
     }



    /*@OperationLog(bizId = "'getPermCode'",bizType = "'getPermCode'",msg = "'获取权限编码'")*/
    @GetMapping("getPermCode")
    public R getPermCode()
    {
        List<Map<Integer, List<Integer>>> maps = new ArrayList<>();
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1000);
        list1.add(3000);
        list1.add(5000);
        map1.put(1, list1);
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(2000);
        list2.add(4000);
        list2.add(6000);
        map2.put(2, list2);
        maps.add(map1);
        maps.add(map2);
        return JsonResult.OK(maps);
    }

    /**
     * 用户列表
     * @param
     * @param
     * @param pageSize
     * @return
     * @throws Exception
     */
     @GetMapping("list")
     public R list(User user, @RequestParam(value = "pageIndex") int pageIndex, @RequestParam(value = "pageSize") int pageSize) throws Exception {
        return  exec(2,()->{
            Pagination pagination = new Pagination(pageIndex);
           return getEntityListWithPaging(buildQueryWrapperByDTO(user), pagination);
         });
     }

    /**
     *
     * @param addRolesDTO
     * @return
     */
     @PostMapping("addRoles")
     public R addRoles(AddRolesDTO addRolesDTO) {
         return exec(()->{
          return JsonResult.OK(getService().createOrUpdateN2NRelations(UserRole::getUserId,addRolesDTO.getUserId(),UserRole::getRoleId,addRolesDTO.getRoleIds()));
         });
     }
}
