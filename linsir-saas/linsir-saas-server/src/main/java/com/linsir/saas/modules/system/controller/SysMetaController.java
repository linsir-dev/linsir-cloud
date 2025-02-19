package com.linsir.saas.modules.system.controller;


import com.linsir.SaaS.modules.system.dto.SysMetaAddDTO;
import com.linsir.SaaS.modules.system.entity.SysMeta;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.SysMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：SysMeta
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/20 4:50
 */
@RestController
@RequestMapping("/sysMeta/")
public class SysMetaController extends BaseCrudRestController<SysMeta> {

    @Autowired
    private SysMetaService sysMetaService;

    @PostMapping("add")
    public R addSysMetaAndResource(@RequestBody SysMetaAddDTO sysMetaAddDTO)
    {
        return exec(()->{
           return JsonResult.OK(sysMetaService.createEntityAndRelatedEntity(sysMetaAddDTO.getSysMeta(),sysMetaAddDTO.getSysResource()));
        });
    }

}
