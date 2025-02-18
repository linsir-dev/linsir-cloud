package com.linsir.saas.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.entity.SysTenantExtBusiness;
import com.linsir.SaaS.modules.system.entity.SysTenantExtWeb;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.SysTenantExtBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description：SysTenantExtBusinessController
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/19 2:03
 */
@RestController
@RequestMapping("/sysTenantExtBusiness/")
public class SysTenantExtBusinessController extends BaseCrudRestController<SysTenantExtBusiness> {

    @Autowired
    private SysTenantExtBusinessService sysTenantExtBusinessService;

    @PostMapping("add")
    public R add(@RequestBody SysTenantExtBusiness sysTenantExtBusiness) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return createEntity(sysTenantExtBusiness);
        });
    }

    /**
     *
     * @param sysTenantExtBusiness
     * @return
     */
    @PostMapping("addBySysTenantId")
    public R addBySysTenantId(Long sysTenantId, @RequestBody SysTenantExtBusiness sysTenantExtBusiness) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return JsonResult.OK(sysTenantExtBusinessService.createEntity(sysTenantId,sysTenantExtBusiness));
        });
    }

    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id) throws Exception {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            return deleteEntity(id);
        });
    }

    @PostMapping("update")
    public R update(@RequestBody SysTenantExtBusiness sysTenantExtBusiness) {
        return exec(TypeConstant.LOG_TYPE_5,()->{
            return updateEntity(sysTenantExtBusiness.getId(),sysTenantExtBusiness);
        });
    }

    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }

}
