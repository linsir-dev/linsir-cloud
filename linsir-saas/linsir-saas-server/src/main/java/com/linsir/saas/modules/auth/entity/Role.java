package com.linsir.saas.modules.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * @author Administrator
 * @title: Role
 * @projectName lins
 * @description:
 * @date 2022/1/17 11:57
 */
@Data
@TableName("role")
public class Role extends BaseEntity {

    private String roleName;

    private String roleGroup;
}
