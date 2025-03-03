package com.linsir.auth.modules.rabc.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.auth.modules.rabc.dto.UserQueryDTO;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.mapper.UserMapper;
import com.linsir.auth.modules.rabc.service.UserService;
import com.linsir.auth.modules.rabc.vo.UserVO;
import com.linsir.core.mybatis.data.protect.DataEncryptHandler;
import com.linsir.core.mybatis.exception.BusinessException;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:30:15
 */
@Slf4j
@Service
public class UserServiceImpl  extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private DataEncryptHandler dataEncryptHandler;

    public UserVO getByAccount(String account) {
        return null;
    }

    public List<UserVO> list(UserQueryDTO queryDTO) {

        return null;
        //getViewObject()
        //return List.of();
    }

    /**
     * @description: loadUserByUsername
     * @date: 2025/2/23 4:17
     * @Auther: linsir
     */
    @Override
    public User loadUserByUsername(String userName,String password)  {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("account", userName);
                /*.or()
                .eq("password", userName);*/  //账户，邮箱，或者都可以
        User user = getOne(queryWrapper);
        if (user != null){
            if (!user.isAccountNonExpired()){
                log.info("账号过期");
                throw new BusinessException();
            }
            if (!user.isAccountNonLocked()){
                log.info("账号锁住了");
                throw new BusinessException("账号不存在");
            }
            if (!user.isCredentialsNonExpired()){
                log.info("账号 meiy pingz");
                throw new BusinessException("账号不存在");
            }
            log.info(dataEncryptHandler.decrypt(user.getPassword()));
            if(password.equals(dataEncryptHandler.decrypt(user.getPassword()))){
                return user;
            }
        }else {
            throw new BusinessException("账号不存在");
        }
        return null;
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
