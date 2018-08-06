package com.yhub.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.yhub.api.RoleService;
import com.yhub.dao.RoleDao;
import com.yhub.entity.user.RoleDO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service(interfaceClass=RoleService.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public int insert(RoleDO roleDO) {
        return roleDao.insert(roleDO);
    }

    @Override
    public int update(RoleDO roleDO) {
        return roleDao.update(roleDO);
    }

    @Override
    public int delete(Long id) {
        return roleDao.delete(id);
    }

    @Override
    public RoleDO selectById(Long id) {
        return roleDao.selectById(id);
    }
}
