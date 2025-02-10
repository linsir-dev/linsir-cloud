package com.linsir.saas.modules.auth.vo;


import com.linsir.core.mybatis.binding.annotation.BindCount;
import com.linsir.core.mybatis.binding.annotation.BindEntityList;
import com.linsir.saas.modules.auth.entity.Role;
import com.linsir.saas.modules.auth.entity.RoleResource;
import com.linsir.saas.modules.system.entity.SysResource;
import lombok.Data;

import java.util.List;

/**
 * @author: Administrator
 * @date: 2022/2/14 11:56
 * @description:
 */
@Data
public class RoleVO extends Role {
    private String roleGroupName;

    @BindEntityList(entity = SysResource.class,condition = "this.id=role_resource.role_id AND role_resource.resource_id=id")
    private List<SysResource> sysResourceList;

    @BindCount(entity = RoleResource.class,condition = "this.id = role_id")
    private Integer roleResourceCount;
}
