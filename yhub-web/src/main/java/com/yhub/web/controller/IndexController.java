package com.yhub.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/3
 */
@Controller
@Api(value="page controller",description="页面跳转")
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ApiOperation(value="首页",notes="首页跳转",httpMethod = "GET")
    public String index(){
        return "main";
    }

    @RequestMapping(value = "/403",method = RequestMethod.GET)
    @ApiOperation(value="403",notes="403跳转",httpMethod = "GET")
    public String unauthorizedUrl(){
        return "403";
    }
}
