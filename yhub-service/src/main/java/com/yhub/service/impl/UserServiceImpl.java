package com.yhub.service.impl;

import java.util.List;

import com.yhub.api.UserService;
import com.yhub.dao.UserDao;
import com.yhub.entity.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDO selectByPrimaryKey(Long id) {
        return this.userDao.selectByPrimaryKey(id);
    }

    @Override
    public void insert(UserDO userDo) {
        this.userDao.insert(userDo);
    }

    @Override
    public List<UserDO> selectAll() {
        return this.userDao.selectAll();
    }
}