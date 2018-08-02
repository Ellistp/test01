package com.yhub.web.controller;

import com.yhub.common.model.Result;
import com.yhub.dao.UserDao;
import com.yhub.entity.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/27 0027.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public Result<String> getUser(){
        UserDO userDO = this.userDao.selectByAccount("zhangsan");
        return Result.createSuccessResult(userDO.toString());
    }
}
