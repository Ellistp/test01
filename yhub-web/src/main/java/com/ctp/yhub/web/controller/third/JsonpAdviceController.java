package com.ctp.yhub.web.controller.third;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @author chengtianping
 * @description jsonp 请求
 * @date 2017/8/30
 */
@ControllerAdvice("com.ctp.yhub.web.controller")
public class JsonpAdviceController extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdviceController(){
        super("callback","jsonp");
    }
}
