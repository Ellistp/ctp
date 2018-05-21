package com.ctp.ghub.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import com.ctp.ghub.model.ErrorConstant;
import com.ctp.ghub.model.Result;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/21
 */
public class SpringGlobalExceptionHandler extends SimpleMappingExceptionResolver {

    private static Logger log = Logger.getLogger(SpringGlobalExceptionHandler.class);

    @Override
    public ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception ex) {
        ModelAndView modelAndView = null;
        httpServletResponse.setCharacterEncoding("utf-8");
        String accept = httpServletRequest.getHeader("accept");
        boolean isAjaxRequest = accept != null && !(accept.indexOf("application/json") != -1
            || (httpServletRequest.getHeader("X-Requested-With") != null
            && httpServletRequest.getHeader("X-Requested-With").indexOf("XMLHttpRequest") != -1));
        if (!isAjaxRequest) {
            modelAndView = super.doResolveException(httpServletRequest, httpServletResponse, o, ex);
        } else {
            PrintWriter writer = null;
            try {
                // json 请求返回
                httpServletResponse.setContentType("application/json; charset=utf-8");
                writer = httpServletResponse.getWriter();
                Result<String> result = Result.createFailResult(ErrorConstant.SYS_ERR);
                writer.write(JSONObject.toJSONString(result));
                writer.flush();
            } catch (IOException e) {
                if (log.isInfoEnabled()) {
                    logger.error(e);
                }
            }finally{
                if(null != writer){
                    writer.flush();
                    writer.close();
                }
            }
            return null;
        }
        return modelAndView;
    }
}
