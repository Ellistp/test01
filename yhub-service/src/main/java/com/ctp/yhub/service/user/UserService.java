package com.ctp.yhub.service.user;

import java.util.List;

import com.ctp.yhub.model.UserDO;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    UserDO selectByPrimaryKey(Long id);

    /**
     * 插入一条数据
     * @param userDo
     * @return
     */
    void insert(UserDO userDo);

    /**
     * 查找所有的用户
     * @return
     */
    List<UserDO> selectAll();
}
