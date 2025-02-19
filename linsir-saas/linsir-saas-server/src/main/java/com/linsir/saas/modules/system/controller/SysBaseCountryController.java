package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.dto.SysTenantDTO;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.SaaS.modules.system.vo.SysTenantVO;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysBaseCountry;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.mybatis.vo.Pagination;
import com.linsir.core.results.R;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/30 16:45:59
 */
@RestController
@RequestMapping("/sysBaseCountry/")
public class SysBaseCountryController extends BaseCrudRestController<SysBaseCountry> {

    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }


    /**
     * 列表
     * @description: list
     * @date: 2025/2/19 19:48
     * @Auther: linsir
     */
    @GetMapping("list")
    public R list(SysBaseCountry sysBaseCountry, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysBaseCountry> sysTenantQueryWrapper = buildQueryWrapperByDTO(sysBaseCountry);
            Pagination pagination  = new Pagination();
            pagination.setPageIndex(page);
            pagination.setPageSize(pageSize);
            return getEntityListWithPaging(sysTenantQueryWrapper, pagination);
        });
    }

    @GetMapping("getListByContinent")
    public R getListByContinent(String continent)
    {
        return exec(()->{
            QueryWrapper<SysBaseCountry> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("continent",continent);
            return JsonResult.OK(getEntityList(queryWrapper));
        });
    }

}
