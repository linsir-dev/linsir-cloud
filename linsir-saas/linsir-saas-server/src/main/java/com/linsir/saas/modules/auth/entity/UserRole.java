package com.linsir.saas.modules.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.entity.BaseEntity;
import lombok.Data;

/**
 * @author Administrator
 * @title: AccountRole
 * @projectName lins
 * @description:
 * @date 2022/1/17 18:26
 */
@Data
@TableName
public class UserRole extends BaseEntity {
    private Long userId;
    private Long roleId;
}
