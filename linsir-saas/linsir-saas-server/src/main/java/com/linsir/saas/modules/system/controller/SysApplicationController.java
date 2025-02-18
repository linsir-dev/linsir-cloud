package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysApplication;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.mybatis.vo.Pagination;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.impl.SysApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：linsir
 * @date ：Created in 2022/8/27 10:17
 * @description：应用
 * @modified By：
 * @version: 0.0.1
 */
@RestController
@RequestMapping("/sysApplication/")
public class SysApplicationController extends BaseCrudRestController<SysApplication> {

    @Autowired
    private SysApplicationServiceImpl sysApplicationService;

    @PostMapping("add")
    public R add(@RequestBody SysApplication sysApplication) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return createEntity(sysApplication);
        });
    }


    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id)  {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            return deleteEntity(id);
        });
    }

    @PostMapping("update")
    public R update(@RequestBody SysApplication sysApplication) {
        return exec(TypeConstant.LOG_TYPE_5,()->{
            return updateEntity(sysApplication.getId(),sysApplication);
        });
    }


    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }


    @GetMapping("list")
    public R list(SysApplication sysApplication, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysApplication> sysTenantQueryWrapper = buildQueryWrapperByDTO(sysApplication);
            Pagination pagination  = new Pagination();
            pagination.setPageIndex(page);
            pagination.setPageSize(pageSize);
            return getEntityListWithPaging(sysTenantQueryWrapper, pagination);
        });
    }

}
