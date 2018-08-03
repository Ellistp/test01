package com.yhub.web.controller;

import com.yhub.common.model.Result;
import com.yhub.dao.UserDao;
import com.yhub.entity.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/27 0027.
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getUser(){
        UserDO userDO = this.userDao.selectByAccount("zhangsan");
        return Result.createSuccessResult(userDO.toString());
    }
}
