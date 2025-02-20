package com.linsir.auth.modules.rabc.entity;

/**
 * @author Administrator   账号主数据
 * @title: Account
 * @projectName lins
 * @description: 账号
 * @date 2021/12/17 12:45
 *
 */

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user")
public class User extends BaseModel {

    private String account;

    private String password;

    private int type;

    /*过期时间*/
    private String timeExpiration;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

}
