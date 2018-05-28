package com.ctp.yhub.common.exception;

/**
 * @author chengtianping
 * @description
 * @date 2017/8/30
 */
public class SpringBootException {

    private boolean ok;

    private String msg;

    public SpringBootException(boolean ok, String msg){
        this.ok = ok;
        this.msg = msg;
    }

    public SpringBootException(){}

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
