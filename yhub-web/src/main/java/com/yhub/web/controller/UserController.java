package com.yhub.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.yhub.common.constant.Constant;
import com.yhub.common.constant.PermissionSignConstant;
import com.yhub.common.constant.RoleSignConstant;
import com.yhub.entity.user.UserDO;
import com.yhub.service.UserService;
import com.yhub.web.model.LoginReqData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private UserService userService;

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    /**
     * 登录
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@Valid LoginReqData loginReqData, BindingResult result, Model model, HttpServletRequest request) throws
        IOException {
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "redirect:/index";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数校验错误！");
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(loginReqData.getUsername(), loginReqData.getPassword(),false));
            // 验证成功在Session中保存用户信息
            UserDO userDO = this.userService.selectByAccount(loginReqData.getUsername());
            request.getSession().setAttribute(Constant.SESSION_LOGIN_USER, userDO);
        } catch (AuthenticationException e) {
            // 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
            return "login";
        }
        return "redirect:/index";
    }

    /**
     * 用户登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(Constant.SESSION_LOGIN_USER);
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSignConstant.ADMIN)
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSignConstant.USER_CREATE)
    public String create() {
        return "拥有user:create权限,能访问";
    }
}
