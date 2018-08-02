package com.yhub.dao;

import com.yhub.entity.user.RoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Mapper
public interface RoleDao {

    /**
     * 添加记录
     * @param roleDO
     * @return
     */
    int insert(RoleDO roleDO);

    /**
     * 更新记录
     * @param roleDO
     * @return
     */
    int update(RoleDO roleDO);

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
    RoleDO selectById(Long id);
}
