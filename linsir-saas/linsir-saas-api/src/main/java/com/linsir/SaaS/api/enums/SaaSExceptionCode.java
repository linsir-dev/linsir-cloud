package com.linsir.SaaS.api.enums;


import com.linsir.core.code.ICode;

/**
 * @author Administrator
 * @title: AuthExceptionCode
 * @projectName linsir
 * @description:
 * @date 2022/2/9 18:47
 */
public enum SaaSExceptionCode implements ICode,Cloneable {
    ;

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public boolean status() {
        return false;
    }
}
