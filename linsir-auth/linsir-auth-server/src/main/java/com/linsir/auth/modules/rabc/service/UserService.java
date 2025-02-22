package com.linsir.auth.modules.rabc.service;




import com.linsir.auth.modules.rabc.dto.UserQueryDTO;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.vo.UserVO;
import com.linsir.core.mybatis.service.BaseService;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:29:42
 */

public interface UserService extends BaseService<User> {
    UserVO getByAccount(String account);

    List<UserVO> list(UserQueryDTO queryDTO);

    User loadUserByUsername(String userName);

    boolean check(String username, String password);
}
