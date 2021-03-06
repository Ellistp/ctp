package com.ctp.ghub.security;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.ctp.ghub.constant.Constant;
import com.ctp.ghub.model.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class ShiroUtil {

	public static UserDO getUser(){
		UserDO userInfo = (UserDO)getValueFromSession(Constant.SESSION_LOGIN_USER);
		if (userInfo == null) {
			userInfo = (UserDO)SecurityUtils.getSubject().getPrincipal();
		}
		return userInfo;
	}
	
	/**
	 * 获取当前用户的Session
	 */
	public static Session getSession(boolean createIfNotExist){
		return SecurityUtils.getSubject().getSession(createIfNotExist);
	}


	
	/**
	 * 把值放入到当前登录用户的Session里
	 */
	public static boolean setValueToSession(Object key ,Object value){
		Session s = getSession(true);
		if(s == null){
			return false;
		}
		
		s.setAttribute(key, value);
		return true;
	}
	
	/**
	 * 从当前登录用户的Session里取值
	 */
	public static Object getValueFromSession(Object key){
		Session s = getSession(false);
		if(s == null){
			return null;
		}
		return s.getAttribute(key);
	}
	
	/**
	 * 是否是ajax请求
	 */
	public static boolean isAjax(ServletRequest request){
		return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
	}
}
