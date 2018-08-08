package com.yhub.service.impl;

import java.util.List;

import com.yhub.mapper.UserRoleMapper;
import com.yhub.entity.user.UserRoleDO;
import com.yhub.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int insert(UserRoleDO userRoleDO) {
        return userRoleMapper.insert(userRoleDO);
    }

    @Override
    public int update(UserRoleDO userRoleDO) {
        return userRoleMapper.update(userRoleDO);
    }

    @Override
    public int delete(Long id) {
        return userRoleMapper.delete(id);
    }

    @Override
    public UserRoleDO selectById(Long id) {
        return userRoleMapper.selectById(id);
    }

    @Override
    public List<UserRoleDO> selectRolesByUserId(Long userId) {
        return userRoleMapper.selectRolesByUserId(userId);
    }
}