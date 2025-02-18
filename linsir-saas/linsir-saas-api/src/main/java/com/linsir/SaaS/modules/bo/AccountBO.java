package com.linsir.SaaS.modules.bo;

import com.linsir.SaaS.modules.dto.auth.AccountDto;
import com.linsir.SaaS.modules.dto.auth.RoleDto;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @title: AccountBO
 * @projectName linsir
 * @description: 集合账号相关 角色、权限、成员
 * @date 2022/2/10 10:28
 */
@Data
public class AccountBO {

    private AccountDto accountDto;

    private List<RoleDto> roleDtos;
    
}
