package com.linsir.saas.modules.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.core.mybatis.binding.Binder;
import com.linsir.saas.modules.auth.entity.User;
import com.linsir.saas.modules.auth.mapper.UserMapper;
import com.linsir.saas.modules.auth.service.UserService;
import com.linsir.saas.modules.auth.vo.UserVO;
import org.springframework.stereotype.Service;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:30:15
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    /**
     * 按照名称获取 用户信息
     * @param userName
     * @return
     */
    @Override
    public UserVO getByName(String userName) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name",userName);
        User user = getOne(userQueryWrapper);
        UserVO userVO = Binder.convertAndBindRelations(user,UserVO.class);
        return userVO;
    }
}
