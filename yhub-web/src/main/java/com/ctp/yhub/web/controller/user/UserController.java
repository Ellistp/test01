package com.ctp.yhub.web.controller.user;

import com.ctp.yhub.common.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/27 0027.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public Result<String> getTest(){
        return Result.createSuccessResult("测试中。。。。。");
    }
}
