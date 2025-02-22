package com.linsir.auth.modules.rabc.service.impl;


import com.linsir.auth.modules.rabc.dto.UserQueryDTO;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.mapper.UserMapper;
import com.linsir.auth.modules.rabc.service.UserService;
import com.linsir.auth.modules.rabc.vo.UserVO;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:30:15
 */

@Service
public class UserServiceImpl  extends BaseServiceImpl<UserMapper, User> implements UserService {


    public UserVO getByAccount(String account) {
        return null;
    }

    public List<UserVO> list(UserQueryDTO queryDTO) {

        return null;
        //getViewObject()
        //return List.of();
    }

    @Override
    public User loadUserByUsername(String userName) {
        User user = new User();
        user.setAccount(userName);
        user.setPassword("123456");
        return user;
    }

    @Override
    public boolean check(String username, String password) {
        boolean flag = false;
        User user = loadUserByUsername(username);
        if(user.getPassword().equals(password)) {
            flag = true;
        }
        return true;
    }


    /**
     * 按照名称获取 用户信息
     * @param account
     * @return
     */
    /*@Override
    public UserVO getByAccount(String account) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account",account);
        User user = getOne(userQueryWrapper);
        return Binder.convertAndBindRelations(user,UserVO.class);
    }*/
}
