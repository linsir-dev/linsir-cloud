package com.linsir.saas.modules.auth.mapper;


import com.linsir.core.mapper.BaseCrudMapper;
import com.linsir.saas.modules.auth.entity.UserExt;
import org.apache.ibatis.annotations.Mapper;

/**
 * description:
 * *******************************************************
 * <p>
 * user 扩展关联表  *
 * ******************************************************
 *
 * @author: linsir
 * @version: 0.0.1  *
 * @date: 2023/4/11 22:51
 */

@Mapper
public interface UserExtMapper extends BaseCrudMapper<UserExt> {
}
