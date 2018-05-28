package com.ctp.yhub.service.user.impl;

import java.util.List;

import com.ctp.yhub.dao.UserDao;
import com.ctp.yhub.entity.user.UserDO;
import com.ctp.yhub.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
@Service
public class UserServiceImpl implements UserService{

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
