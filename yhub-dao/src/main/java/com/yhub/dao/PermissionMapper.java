package com.yhub.dao;

import com.yhub.entity.user.PermissionDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Mapper
public interface PermissionMapper {

    /**
     * 添加记录
     * @param permissionDO
     * @return
     */
    int insert(PermissionDO permissionDO);

    /**
     * 更新记录
     * @param permissionDO
     * @return
     */
    int update(PermissionDO permissionDO);

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
    PermissionDO selectById(Long id);
}
