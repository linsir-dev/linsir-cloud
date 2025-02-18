package com.linsir.auth.modules.rabc.mapper;

import com.linsir.base.core.mapper.BaseCrudMapper;
import com.linsir.saas.modules.rabc.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @title: RoleMapper
 * @projectName lins
 * @description:
 * @date 2022/1/18 12:41
 */
@Mapper
public interface RoleMapper extends BaseCrudMapper<Role> {
}
