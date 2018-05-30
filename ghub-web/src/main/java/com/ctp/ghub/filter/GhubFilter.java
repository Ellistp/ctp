package com.ctp.ghub.filter;


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
 * Created by Administrator on 2018/5/12 0012.
 * 需要在 web.xml中 直接配置
 */
public class GhubFilter implements Filter {
    private Logger logger = Logger.getLogger(GhubFilter.class);
    private static final String DEFAULT_CHARSET="UTF-8";

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("init ghub filter   ;" + filterConfig.getFilterName());
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
