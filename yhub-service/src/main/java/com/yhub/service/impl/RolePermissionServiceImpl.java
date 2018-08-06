package com.yhub.service.impl;

import java.util.List;

import com.yhub.api.RolePermissionService;
import com.yhub.dao.RolePermissionMapper;
import com.yhub.entity.user.RolePermissionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int insert(RolePermissionDO rolePermissionDO) {
        return rolePermissionMapper.insert(rolePermissionDO);
    }

    @Override
    public int update(RolePermissionDO rolePermissionDO) {
        return rolePermissionMapper.update(rolePermissionDO);
    }

    @Override
    public int delete(Long id) {
        return rolePermissionMapper.delete(id);
    }

    @Override
    public RolePermissionDO selectById(Long id) {
        return rolePermissionMapper.selectById(id);
    }

    @Override
    public List<RolePermissionDO> selectPermissionsByRoleId(Long roleId) {
        return this.rolePermissionMapper.selectPermissionsByRoleId(roleId);
    }
}
