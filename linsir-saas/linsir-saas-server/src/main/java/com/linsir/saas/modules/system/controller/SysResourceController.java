package com.linsir.saas.modules.system.controller;

import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.SaaS.modules.system.entity.SysResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/29 16:14:57
 */

@RestController
@RequestMapping("v1/sysResource/")
public class SysResourceController extends BaseCrudRestController<SysResource> {

   /* @Autowired
    private SysResourceServiceImpl sysResourceService;

    @GetMapping("list")
    public ResResult list(SysResourceDto sysResourceDto,int page,int pageSize) throws Exception {
        R result = null;

        QueryWrapper queryWrapper = buildQueryWrapperByDTO(sysResourceDto);
        Pagination pagination = new Pagination();
        pagination.setPageIndex(page);
        pagination.setPageSize(pageSize);
        Summary summary = new Summary("1","xxx");

        result = exec("获取树形资源列表",()->{
                List<SysResourceVO> sysResourceVOList = sysResourceService.treeList(queryWrapper,pagination);
                PageVO<SysResourceVO,Summary> pageVO = new PageVO<>(pagination,sysResourceVOList);
            return  Result.SUCCESS(pageVO);
        });
        return new ResResult<>(result);
    }*/
}
