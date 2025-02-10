package com.linsir.saas.modules.auth.mapper;

import com.linsir.core.mapper.BaseCrudMapper;
import com.linsir.saas.modules.auth.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @title: AccountRoleMapper
 * @projectName lins
 * @description:
 * @date 2022/1/18 10:55
 */
@Mapper
public interface UserRoleMapper extends BaseCrudMapper<UserRole> {

//
//    @Select("select * from lins_role " +
//            "left join " +
//            "lins_account_role on lins_role.id = lins_account_role.role_id " +
//            "where lins_account_role.account_id = #{accountId}")
//    List<Role> getRolesByAccountId(Long accountId);

}
