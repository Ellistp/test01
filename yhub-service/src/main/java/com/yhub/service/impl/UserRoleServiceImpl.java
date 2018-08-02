package com.yhub.service.impl;

import java.util.List;

import com.yhub.api.UserRoleService;
import com.yhub.dao.UserRoleDao;
import com.yhub.entity.user.UserRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public int insert(UserRoleDO userRoleDO) {
        return userRoleDao.insert(userRoleDO);
    }

    @Override
    public int update(UserRoleDO userRoleDO) {
        return userRoleDao.update(userRoleDO);
    }

    @Override
    public int delete(Long id) {
        return userRoleDao.delete(id);
    }

    @Override
    public UserRoleDO selectById(Long id) {
        return userRoleDao.selectById(id);
    }

    @Override
    public List<UserRoleDO> selectRolesByUserId(Long userId) {
        return userRoleDao.selectRolesByUserId(userId);
    }
}