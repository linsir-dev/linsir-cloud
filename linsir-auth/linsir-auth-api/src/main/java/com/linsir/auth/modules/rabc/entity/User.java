package com.linsir.auth.modules.rabc.entity;

/**
 * @author Administrator   账号主数据
 * @title: Account
 * @projectName lins
 * @description: 账号
 * @date 2021/12/17 12:45
 *
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.data.protect.DefaultEncryptTypeHandler;
import com.linsir.core.mybatis.entity.BaseModel;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user")
public class User extends BaseModel {

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$", message = "由数字和字母组成，并且要同时含有数字和字母，且长度要在6-16位之间")
    private String account;

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$", message = "由数字和字母组成，并且要同时含有数字和字母，且长度要在6-16位之间")
    @TableField(typeHandler = DefaultEncryptTypeHandler.class)
    private String password;

    private int type;

    /*过期时间*/
    private String timeExpiration;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

}
