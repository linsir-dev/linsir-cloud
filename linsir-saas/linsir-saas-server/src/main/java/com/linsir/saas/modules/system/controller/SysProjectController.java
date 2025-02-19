package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysProject;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.mybatis.vo.Pagination;
import com.linsir.core.results.R;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/07 14:06:24
 */
@RestController
@RequestMapping("/sysProject/")
public class SysProjectController extends BaseCrudRestController<SysProject> {


    /**
     * 基于 App添加项目
     * @param sysProject
     * @return
     */
    @PostMapping("add")
    public R add(SysProject sysProject) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return createEntity(sysProject);
        });
    }

    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id)  {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            return deleteEntity(id);
        });
    }

    @PostMapping("update")
    public R update(@RequestBody SysProject sysProject) {
        return exec(TypeConstant.LOG_TYPE_5,()->{
            return updateEntity(sysProject.getId(),sysProject);
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
    public R list(SysProject sysProject, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysProject> sysTenantQueryWrapper = buildQueryWrapperByDTO(sysProject);
            Pagination pagination  = new Pagination();
            pagination.setPageIndex(page);
            pagination.setPageSize(pageSize);
            return getEntityListWithPaging(sysTenantQueryWrapper, pagination);
        });
    }
}
