package com.linsir.saas.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.entity.SysTenantExtWeb;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.SysTenantExtWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description：SysTenantExtWebController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/18 23:32
 */
@RestController
@RequestMapping("/sysTenantExtWeb/")
public class SysTenantExtWebController extends BaseCrudRestController<SysTenantExtWeb> {


    @Autowired
    private SysTenantExtWebService sysTenantExtWebService;

    @PostMapping("add")
    public R add(@RequestBody SysTenantExtWeb sysTenantExtWeb) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return createEntity(sysTenantExtWeb);
        });
    }

    /**
     *
     * @param sysTenantExtWeb
     * @return
     */
    @PostMapping("addBySysTenantId")
    public R addBySysTenantId(Long sysTenantId, @RequestBody SysTenantExtWeb sysTenantExtWeb) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return JsonResult.OK(sysTenantExtWebService.createEntity(sysTenantId,sysTenantExtWeb));
        });
    }

    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id) throws Exception {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            return deleteEntity(id);
        });
    }

    @PostMapping("update")
    public R update(@RequestBody SysTenantExtWeb sysTenantExtWeb) {
        return exec(TypeConstant.LOG_TYPE_5,()->{
            return updateEntity(sysTenantExtWeb.getId(),sysTenantExtWeb);
        });
    }

    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }

    /**
     * 按照域名进行查找租户web信息
     * @param domain
     * @return
     */
    @GetMapping("getByDomain")
    public R getByDomain(String domain) throws Exception {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysTenantExtWeb> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("domain_name",domain);
            return JsonResult.OK(getService().getSingleEntity(queryWrapper));
        });
    }
}
