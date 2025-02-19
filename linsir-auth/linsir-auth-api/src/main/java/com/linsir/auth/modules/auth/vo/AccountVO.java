package com.linsir.auth.modules.auth.vo;

import com.linsir.core.mybatis.binding.annotation.BindDict;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2022/2/14 12:00
 * @description:
 */

@Data
public class AccountVO /*extends CommonBaseVO*/ {

    private String account;

    private String password;


    private int enable;

    @BindDict(type = "ACCOUNT_STATUS",field = "enable")
    private String enableLabel;


    /*过期时间*/
    private String timeExpiration;
}
