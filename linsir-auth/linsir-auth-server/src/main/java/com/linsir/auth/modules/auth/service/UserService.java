package com.linsir.auth.modules.auth.service;

import com.linsir.core.mybatis.service.BaseService;
import com.linsir.auth.modules.auth.entity.User;
import com.linsir.auth.modules.auth.vo.UserVO;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:29:42
 */

public interface UserService extends BaseService<User> {
    UserVO getByName(String username);
}
