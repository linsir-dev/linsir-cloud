package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.saas.modules.system.entity.SysProject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/07 14:06:24
 */
@RestController
@RequestMapping("/v1/sysProject/")
public class SysProjectController extends BaseCrudRestController<SysProject> {


    /**
     * 无查询列表
     * @return
     * @throws Exception
     */
    /*@RequestMapping(value = "list",method = {RequestMethod.GET})
    public JsonResult<List<SysProject>> list(String type) throws Exception {
        SysProjectDto sysProjectDto = new SysProjectDto();
        sysProjectDto.setType(type);
        QueryWrapper<SysProjectDto> queryWrapper = super.buildQueryWrapperByQueryParams(sysProjectDto);
        JsonResult<List<SysProject>> jsonResult =null;
         jsonResult = exec(()->{
             return getEntityList(queryWrapper);
        });
         return jsonResult;
    }*/
}
