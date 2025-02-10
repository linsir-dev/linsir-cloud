package com.linsir.saas.modules.auth.mapper;

import com.linsir.core.mapper.BaseCrudMapper;
import com.linsir.saas.modules.auth.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:28:52
 */
@Mapper
public interface UserMapper extends BaseCrudMapper<User> {
}
