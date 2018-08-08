package com.yhub.service.impl;

import com.yhub.mapper.RoleMapper;
import com.yhub.entity.user.RoleDO;
import com.yhub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(RoleDO roleDO) {
        return roleMapper.insert(roleDO);
    }

    @Override
    public int update(RoleDO roleDO) {
        return roleMapper.update(roleDO);
    }

    @Override
    public int delete(Long id) {
        return roleMapper.delete(id);
    }

    @Override
    public RoleDO selectById(Long id) {
        return roleMapper.selectById(id);
    }
}
