package com.linsir.saas.modules.system.mapper;


import com.linsir.core.mybatis.mapper.BaseCrudMapper;
import com.linsir.SaaS.modules.system.entity.SysAuthority;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Administrator
 * @date: 2022/2/15 14:12
 * @description:
 */
@Mapper
public interface AuthorityMapper extends BaseCrudMapper<SysAuthority> {
}
