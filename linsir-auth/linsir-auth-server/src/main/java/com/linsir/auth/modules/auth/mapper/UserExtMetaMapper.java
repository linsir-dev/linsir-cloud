package com.linsir.auth.modules.auth.mapper;

import com.linsir.core.mybatis.mapper.BaseCrudMapper;
import com.linsir.auth.modules.auth.entity.UserExtMeta;
import org.apache.ibatis.annotations.Mapper;

/**
 * description:
 * *******************************************************
 * <p>
 * user meta 扩展  *
 * ******************************************************
 *
 * @author: linsir
 * @version: 0.0.1  *
 * @date: 2023/4/11 22:53
 */
@Mapper
public interface UserExtMetaMapper extends BaseCrudMapper<UserExtMeta> {
}
