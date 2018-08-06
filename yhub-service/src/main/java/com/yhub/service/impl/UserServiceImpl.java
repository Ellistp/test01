package com.yhub.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.yhub.api.UserService;
import com.yhub.dao.UserDao;
import com.yhub.entity.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Service(interfaceClass=UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int insert(UserDO userDO) {
        return userDao.insert(userDO);
    }

    @Override
    public int update(UserDO userDO) {
        return userDao.update(userDO);
    }

    @Override
    public int delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    public UserDO selectById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public UserDO selectByAccount(String account) {
        return this.userDao.selectByAccount(account);
    }
}
