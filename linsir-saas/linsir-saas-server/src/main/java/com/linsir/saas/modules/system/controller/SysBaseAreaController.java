package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysBaseArea;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.impl.SysBaseAreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/31 10:20:20
 */

@RestController
@RequestMapping("/sysBaseArea/")
public class SysBaseAreaController extends BaseCrudRestController<SysBaseArea> {

    @Autowired
    private SysBaseAreaServiceImpl sysBaseAreaService;


    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }


    @GetMapping("getByCountry")
    public R getByCountry(Long country) {

        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysBaseArea> queryWrapper = new QueryWrapper<SysBaseArea>();
            queryWrapper.eq("country_id", country);
            return getEntityList(queryWrapper);
        });
    }

    /**
     * 获取 省或直辖市 特别区
     * @return
     */
    @GetMapping("getChinaProvince")
    public R getChinaProvince()
    {

        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysBaseArea> queryWrapper = new QueryWrapper<SysBaseArea>();
            queryWrapper.eq("country_id", "156")
                    .eq("parent_id",0);
            return getEntityList(queryWrapper);
        });
    }

    /**
     *  多级查询
     * 湖北省 420000
     * 武汉市 420100
     * 江岸区 420102
     * @description: getChinaArea
     * @date: 2025/2/20 1:02
     * @Auther: linsir
     */
    @GetMapping("getChinaArea")
    public  R getChinaArea(String parentId)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysBaseArea> queryWrapper = new QueryWrapper<SysBaseArea>();
            queryWrapper.eq("country_id", "156")
                    .eq("parent_id", parentId);
            return getEntityList(queryWrapper);
        });
    }

}
