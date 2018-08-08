package com.yhub.mapper;

import java.util.List;

import com.yhub.entity.user.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Mapper
public interface UserRoleMapper {

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
