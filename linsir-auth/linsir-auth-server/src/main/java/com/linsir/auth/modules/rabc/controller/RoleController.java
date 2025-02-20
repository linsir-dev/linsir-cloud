package com.linsir.auth.modules.rabc.controller;


import com.linsir.auth.modules.rabc.entity.Role;
import com.linsir.auth.modules.rabc.service.impl.RoleServiceImpl;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.results.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：linsir
 * @date ：Created in 2022/9/1 22:32
 * @description：角色
 * @modified By：
 * @version: 0.0.1
 */
@RestController
@RequestMapping("/role/")
public class RoleController extends BaseCrudRestController<Role> {


    @PostMapping("add")
    public R add(Role role)
    {
        return exec(()->{
            return createEntity(role);
        });
    }

    /*@GetMapping("list")
    public ResResult list(RoleDto roleDto,int page,int pageSize) throws Exception {
        R result = null;
        QueryWrapper queryWrapper = buildQueryWrapperByDTO(roleDto);
        Pagination pagination = new Pagination();
        pagination.setPageSize(pageSize);
        pagination.setPageIndex(page);
        Summary summary = new Summary("1","11");
        result = exec("获取角色列表",()->{
            List<RoleVO> roleVOList = roleService.getViewObjectList(queryWrapper,pagination,RoleVO.class);
            PageVO<RoleVO,Summary> pageVO = new PageVO<>(pagination,roleVOList);
            pageVO.setSummary(summary);
            return  Result.SUCCESS(pageVO);
        });

        return new ResResult<>(result);
    }*/
}
