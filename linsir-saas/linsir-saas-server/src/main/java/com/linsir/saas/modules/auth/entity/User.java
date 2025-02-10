package com.linsir.saas.modules.auth.entity;

/**
 * @author Administrator
 * @title: Account
 * @projectName lins
 * @description: 账号
 * @date 2021/12/17 12:45
 *
 */

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("user")
public class User extends BaseEntity {

    private String userName;

    private String password;

    private int type;

    /*过期时间*/
    private String timeExpiration;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

}
