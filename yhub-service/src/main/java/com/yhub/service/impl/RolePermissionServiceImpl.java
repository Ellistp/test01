package com.yhub.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;

import com.yhub.api.RolePermissionService;
import com.yhub.dao.RolePermissionDao;
import com.yhub.entity.user.RolePermissionDO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service(interfaceClass=RolePermissionService.class)
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public int insert(RolePermissionDO rolePermissionDO) {
        return rolePermissionDao.insert(rolePermissionDO);
    }

    @Override
    public int update(RolePermissionDO rolePermissionDO) {
        return rolePermissionDao.update(rolePermissionDO);
    }

    @Override
    public int delete(Long id) {
        return rolePermissionDao.delete(id);
    }

    @Override
    public RolePermissionDO selectById(Long id) {
        return rolePermissionDao.selectById(id);
    }

    @Override
    public List<RolePermissionDO> selectPermissionsByRoleId(Long roleId) {
        return this.rolePermissionDao.selectPermissionsByRoleId(roleId);
    }
}
