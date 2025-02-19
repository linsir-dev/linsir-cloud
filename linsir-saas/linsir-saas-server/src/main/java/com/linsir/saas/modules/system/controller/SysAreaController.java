package com.linsir.saas.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysArea;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.mybatis.vo.Pagination;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.SysAreaService;
import com.linsir.saas.modules.system.service.impl.SysAreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/25 16:51:05
 */
@RestController
@RequestMapping("/sysArea/")
public class SysAreaController extends BaseCrudRestController<SysArea> {


    @Autowired
    private SysAreaService sysAreaService;


    /**
     * 增加地图
     * @description: add
     * @date: 2025/2/19 20:54
     * @Auther: linsir
     */
    @PostMapping("add")
    public R add(SysArea sysArea) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return createEntity(sysArea);
        });
    }

    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id)  {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            return deleteEntity(id);
        });
    }

    @GetMapping("list")
    public R list(SysArea sysArea, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysArea> sysTenantQueryWrapper = buildQueryWrapperByDTO(sysArea);
            Pagination pagination  = new Pagination();
            pagination.setPageIndex(page);
            pagination.setPageSize(pageSize);
            return getEntityListWithPaging(sysTenantQueryWrapper, pagination);
        });
    }


    @GetMapping("getListByType")
    public R getListByType(String type){
        return exec(TypeConstant.LOG_TYPE_4,()->{
            QueryWrapper<SysArea> sysAreaQueryWrapper = new QueryWrapper<>();
            sysAreaQueryWrapper.eq("type", type);
            return getEntityList(sysAreaQueryWrapper);
        });
    }

    /**
     * 按照id获取下面树节点
     * @description: getAreaTree
     * @date: 2025/2/19 22:58
     * @Auther: linsir
     */
    @GetMapping("getAreaTree/{rootSysAreaId}")
    public R getAreaTree(@PathVariable("rootSysAreaId") Long rootSysAreaId){
      return    exec(()->{
            return JsonResult.OK(sysAreaService.getAreaTree(rootSysAreaId));
        });
    }
}
