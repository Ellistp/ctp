package com.ctp.ghub.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
public class GhubFilter implements Filter {
    private Logger logger = Logger.getLogger(GhubFilter.class);
    private static String encoding;
    private static final String DEFAULT_CHARSET="UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        logger.info("init ghub filter   ;" + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        servletRequest.setCharacterEncoding(DEFAULT_CHARSET);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("destroy filter");
    }
}
