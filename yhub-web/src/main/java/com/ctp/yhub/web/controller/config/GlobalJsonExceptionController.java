package com.ctp.yhub.web.controller.config;

import com.ctp.yhub.common.exception.SpringBootException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chengtianping
 * @description 全局统一处理异常
 * @date 2017/8/30
 */
@RestControllerAdvice("com.ctp.yhub.web.controller")
public class GlobalJsonExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalJsonExceptionController.class);

    /*
     * 只针对使用requestbody 的controller 统一处理异常
     */
    //@ResponseBody
    //@ExceptionHandler(value = Exception.class)
    //public Map exception(Exception ex) throws Exception{
    //    Map<String,Object> map = new HashMap<>();
    //    map.put("code",100);
    //    map.put("msg",ex.getMessage());
    //    return map;
    //}

    /*
     * 只针对使用requestbody 的controller 统一处理异常 自定义异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public SpringBootException exception(Exception ex){
        SpringBootException springBootException = new SpringBootException();
        springBootException.setOk(false);
        springBootException.setMsg(ex.getMessage());
        LOGGER.error(ex.getMessage());
        return springBootException;
    }

}
