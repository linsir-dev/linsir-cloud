package com.linsir.auth.modules.auth.enums;



/**
 * @author Administrator
 * @title: AuthFeatures
 * @projectName linsir
 * @description: 权限相关的功能模块枚举
 * @date 2022/2/9 18:44
 */
public enum AuthFeatures {

    /*账号*/
   /* ACCOUNT_ADD("account:add","账户管理","add","增加账户"),
    ACCOUNT_DEL("account:del","账户管理","del","删除账户"),
    ACCOUNT_UPDATE("account:update","角色管理","update","跟新账号"),

    ACCOUNT_ADD_ROLES("account:addRoles","账户管理","addRoles","增加账户角色"),
    ACCOUNT_GET("account:get","账户管理","get","获取账户"),

    ACCOUNT("account:list","账户管理","list","账户列表"),


    *//*角色*//*
    ROLE_ADD("role:add","角色管理","add","增加角色"),
    ROLE_GET("role:get","角色管理","get","获取单个角色"),
    ROLE_UPDATE("role:get","角色管理","update","更新角色"),
    ROLE_QUERY_LIST("role:queryList","角色管理","queryList","角色查询，全部"),

    *//*权限*//*

    AUTH_ADD("authority:add","权限管理","add","角色增加"),
    ;

    private String code;

    private String moduleName;

    private String methodName;

    private String desc;

    AuthFeatures(String code, String moduleName, String methodName, String desc)
    {
        this.code = code;
        this.moduleName = moduleName;
        this.methodName = methodName;
        this.desc =desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getModuleName() {
        return moduleName;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }



    @Override
    public String getDesc() {
        return desc;
    }*/
}
