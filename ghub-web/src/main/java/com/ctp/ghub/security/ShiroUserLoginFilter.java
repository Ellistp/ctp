package com.ctp.ghub.security;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.alibaba.fastjson.JSONObject;

import com.ctp.ghub.constant.Constant;
import com.ctp.ghub.model.ErrorConstant;
import com.ctp.ghub.model.Result;
import com.ctp.ghub.model.UserDO;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/1
 */
public class ShiroUserLoginFilter extends AccessControlFilter {

    private static Logger logger = LoggerFactory.getLogger(ShiroUserLoginFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
        throws Exception {

        // 检查用户是否已经处于登录态
        UserDO user = ShiroUtil.getUser();
        if(null != user || isLoginRequest(request, response)){
            return true;
        }

        if (ShiroUtil.isAjax(request)) {
            Result<String> result = Result.createFailResult(ErrorConstant.NOT_LOGIN_ERROR);
            writeResult(response, result);
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
        throws Exception {
        saveRequestAndRedirectToLogin(request, response);
        return false ;

    }

    protected void writeResult(ServletResponse response, Result<String> result){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding(Constant.APPLICATION_ENCODING_UTF_8);
            out = response.getWriter();
            out.println(JSONObject.toJSONString(result));
        } catch (Exception e) {
            logger.error("Unknown exception", e);
        }finally{
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }
}
