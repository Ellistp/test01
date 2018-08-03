package com.yhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/3
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "main";
    }

    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public String unauthorizedUrl(){
        return "403";
    }
}
