package com.yhub.service.impl;

import com.yhub.mapper.UserMapper;
import com.yhub.entity.user.UserDO;
import com.yhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public int update(UserDO userDO) {
        return userMapper.update(userDO);
    }

    /**
     * 增删改 readOnly 设置为false , 默认也是false
     * @param id
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    public UserDO selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserDO selectByAccount(String account) {
        return this.userMapper.selectByAccount(account);
    }
}
