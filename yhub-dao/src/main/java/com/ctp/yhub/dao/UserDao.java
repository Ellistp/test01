package com.ctp.yhub.dao;

import java.util.List;

import com.ctp.yhub.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
@Mapper
public interface UserDao {

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    UserDO selectByPrimaryKey(Long id);

    /**
     * 插入一条数据
     * @param userDO
     * @return
     */
    void insert(UserDO userDO);

    /**
     * 查找所有的用户
     * @return
     */
    List<UserDO> selectAll();
}
