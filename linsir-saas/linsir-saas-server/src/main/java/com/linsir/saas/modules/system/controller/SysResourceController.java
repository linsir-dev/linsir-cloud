package com.linsir.saas.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.SaaS.modules.system.vo.SysResourceVO;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysResource;
import com.linsir.core.mybatis.util.BeanUtils;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.saas.modules.system.service.SysResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/29 16:14:57
 */

@RestController
@RequestMapping("/sysResource/")
public class SysResourceController extends BaseCrudRestController<SysResource> {

    private final SysResourceService sysResourceService;

    public SysResourceController(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }

    /**
     * 基于 App 加入 资源  appid 不能为空
     * 基于 project 加入资源，appid 不为空  project 不为空
     * @param sysResource
     * @return
     */
    @PostMapping("add")
    public R add(@RequestBody SysResource sysResource) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return createEntity(sysResource);
        });
    }


    @GetMapping("getTreeByAppId")
    public R getTreeByAppId(Long appId) {
       return exec(TypeConstant.LOG_TYPE_3,()->{
            QueryWrapper<SysResource> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("app_id", appId);
            queryWrapper.orderByAsc("sort");
            List<SysResource> sysResourceList = getService().getEntityList(queryWrapper);
            List<SysResourceVO> treeNodeList = BeanUtils.convertList(sysResourceList, SysResourceVO.class);
            treeNodeList = BeanUtils.buildTree(treeNodeList);
            return JsonResult.OK(treeNodeList);
        });
    }

    /** 按照项目获取资源
     * @description: getProjectResource
     * @date: 2025/2/20 6:33
     * @Auther: linsir
     */
    @GetMapping("getProjectResource")
    public R getProjectResource(Long projectId) {
        return exec(()->{
            return JsonResult.OK(sysResourceService.getProjectResource(projectId));
        });
    }
}
