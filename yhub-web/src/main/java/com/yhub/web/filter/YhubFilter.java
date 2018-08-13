package com.yhub.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2018/5/27 0027.
 */
public class YhubFilter implements Filter {

    private Logger logger = Logger.getLogger(YhubFilter.class);
    private static final String DEFAULT_CHARSET="UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init Yhub filter   ;" + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        servletRequest.setCharacterEncoding(DEFAULT_CHARSET);
        servletResponse.setCharacterEncoding(DEFAULT_CHARSET);
        //主要是对请求头和请求参数中的参数做一些校验工作
        filterChain.doFilter(new HttpServletRequestParameterWrapper(request),response);
    }

    @Override
    public void destroy() {
        logger.info("destroy filter");
    }
}
