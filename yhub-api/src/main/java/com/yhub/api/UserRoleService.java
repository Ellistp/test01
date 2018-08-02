package com.yhub.api;

import java.util.List;

import com.yhub.entity.user.UserRoleDO;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
public interface UserRoleService {

    /**
     * 添加记录
     * @param userRoleDO
     * @return
     */
    int insert(UserRoleDO userRoleDO);

    /**
     * 更新记录
     * @param userRoleDO
     * @return
     */
    int update(UserRoleDO userRoleDO);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询记录
     * @param id
     * @return
     */
    UserRoleDO selectById(Long id);

    List<UserRoleDO> selectRolesByUserId(Long userId);
}
