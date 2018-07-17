package com.ctp.yhub.web.controller;

import java.util.List;

import com.ctp.yhub.common.model.Result;
import com.ctp.yhub.dao.UserDao;
import com.ctp.yhub.entity.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/5/27 0027.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public Result<String> getTest(){
        return Result.createSuccessResult("测试中。。。。。");
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public Result<String> getUser(){
        List<UserDO> userDOList = this.userDao.selectAll();
        int size = CollectionUtils.isEmpty(userDOList) == true?0 : userDOList.size();
        return Result.createSuccessResult(String.valueOf(size));
    }
}
