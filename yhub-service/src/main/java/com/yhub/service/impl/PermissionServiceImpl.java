package com.yhub.service.impl;

import com.yhub.api.PermissionService;
import com.yhub.dao.PermissionMapper;
import com.yhub.entity.user.PermissionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionDao;

    @Override
    public int insert(PermissionDO permissionDO) {
        return permissionDao.insert(permissionDO);
    }

    @Override
    public int update(PermissionDO permissionDO) {
        return permissionDao.update(permissionDO);
    }

    @Override
    public int delete(Long id) {
        return permissionDao.delete(id);
    }

    @Override
    public PermissionDO selectById(Long id) {
        return permissionDao.selectById(id);
    }
}
