package com.linsir.auth.modules.rabc.mapper;

import com.linsir.base.core.mapper.BaseCrudMapper;
import com.linsir.saas.modules.rabc.entity.UserExtMeta;
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
