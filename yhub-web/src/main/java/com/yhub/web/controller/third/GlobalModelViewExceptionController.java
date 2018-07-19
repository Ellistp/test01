package com.yhub.web.controller.third;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chengtianping
 * @description
 * @date 2017/8/30
 */
@ControllerAdvice("com.yhub.web.controller")
public class GlobalModelViewExceptionController {

    /**
     * 渲染页面返回给浏览器 统一处理异常
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView myErrorHandler(Exception ex) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("ok", false);
        modelAndView.addObject("msg", ex.getMessage());
        return modelAndView;
    }
}
