package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.dto.SysTenantDTO;
import com.linsir.SaaS.modules.system.vo.SysTenantVO;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.mybatis.vo.Pagination;
import com.linsir.core.results.R;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.saas.modules.system.service.SysTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @version 1.2.0
 * @ClassName SysTenantController.java
 * @Description 合并 sysTenant
 * @createTime 2022年07月18日 17:57:00
 *
 * by linsir 2025 / 2 /18
 */
@RestController
@RequestMapping("/sysTenant/")
public class SysTenantController extends BaseCrudRestController<SysTenant> {

    /*------------------系统日志类型---------------------*/
    /*系统日志类型： 登录*/
    /*public static final int LOG_TYPE_1 = 1;

    *//*系统日志类型： 操作*//*
    public static final int LOG_TYPE_2 = 2;

    *//*操作日志类型： 查询*//*
    public static final int LOG_TYPE_3 = 3;

    *//*操作日志类型： 添加*//*
    public static final int LOG_TYPE_4 = 4;

    *//*操作日志类型： 更新*//*
    public static final int LOG_TYPE_5 = 5;

    *//*操作日志类型： 删除*//*
    public static final int LOG_TYPE_6 = 6;

    *//*操作日志类型： 倒入*//*
    public static final int LOG_TYPE_7 = 7;

    *//*操作日志类型： 导出*//*
    public static final int LOG_TYPE_8 = 8;*/

    @Autowired
    private SysTenantService sysTenantService;

    /**
     *
     * @Description: 添加租户
     * @Param: [sysTenant]
     * @return: com.linsir.core.vo.jsonResults.ResResult
     * @Author: linsir
     * @Date: 2022/9/23 0:55
     */
    @PostMapping("add")
    public R add(@RequestBody SysTenant sysTenant) {
       return exec(TypeConstant.LOG_TYPE_4,()->{
             sysTenant.setTenantCode(sysTenantService.generateCode());
            return createEntity(sysTenant);
        });
    }

    /**
     * @Description: 删除租户
     * @Param: com.linsir.core.vo.IResult
     * @return: [id]
     * @Author: linsir
     * @Date: 2:54 2023/4/22
     */
    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id)  {
        return exec(TypeConstant.LOG_TYPE_6,()->{
           return deleteEntity(id);
        });
    }

    /**
     * @Author linsir
     * @Description 更新租户信息
     * @Date 14:37 2022/9/26
     * @Param [sysTenant]
     * @return com.linsir.core.vo.jsonResults.ResResult
     **/
    @PostMapping("update")
    public R update(@RequestBody SysTenant sysTenant) {
        return exec(TypeConstant.LOG_TYPE_5,()->{
            return updateEntity(sysTenant.getId(),sysTenant);
        });
    }


    /**
     * @Author linsir
     * @Description  获取租户
     * @Date 20:00 2022/9/26
     * @Param [sysTenantId]
     * @return com.linsir.core.vo.jsonResults.ResResult
     **/
    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }

    /**
     * @Description:
     * @Param: com.linsir.core.vo.IResult
     * @return: [id]
     * @Author: linsir
     * @Date: 2:53 2023/4/22
     */
    @GetMapping("getVO/{id}")
    public R getVO(@PathVariable("id") Long id)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return getViewObject(id, SysTenantVO.class);
        });
    }

    /**
     * 租户列表信息
     * @param sysTenant
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @GetMapping("list")
    public R list(SysTenant sysTenant, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysTenant> sysTenantQueryWrapper = buildQueryWrapperByDTO(sysTenant);
            Pagination pagination  = new Pagination();
            pagination.setPageIndex(page);
            pagination.setPageSize(pageSize);
            return getEntityListWithPaging(sysTenantQueryWrapper, pagination);
        });
    }


    /**
     *
     * @param sysTenantDTO
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("listVO")
    public R listVO(SysTenantDTO sysTenantDTO, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            Pagination pagination  = new Pagination();
            pagination.setPageIndex(page);
            pagination.setPageSize(pageSize);
           return getViewObjectList(sysTenantDTO,pagination,SysTenantVO.class);
        });
    }

    /**
     * 通过租户code获取租户信息
     * @param tenantCode
     * @return
     */
    @GetMapping("getByTenantCode")
    public R getByTenantCode(String tenantCode) {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            QueryWrapper<SysTenant> queryWrapper = new QueryWrapper<SysTenant>().eq("tenant_code", tenantCode);
          return  JsonResult.OK(getService().getViewObject(queryWrapper,SysTenantVO.class));
        });
    }

    /**
     * @Author linsir
     * @Description  自动生成 租户编码
     * @Date 23:27 2022/9/13
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("generateCode")
    public String generateCode()
    {
       return sysTenantService.generateCode();
    }
}
