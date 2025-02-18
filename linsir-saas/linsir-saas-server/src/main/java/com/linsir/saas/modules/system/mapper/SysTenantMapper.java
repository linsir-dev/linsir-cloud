package com.linsir.saas.modules.system.mapper;

import com.linsir.core.mybatis.mapper.BaseCrudMapper;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author linsir
 * @title: TenantMapper
 * @projectName lins
 * @description: mapper
 * @date 2021/12/11 17:30
 */
@Mapper
public interface SysTenantMapper  extends BaseCrudMapper<SysTenant> {

}
