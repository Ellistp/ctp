package com.ctp.ghub.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ctp.ghub.constant.Constant;
import com.ctp.ghub.model.ErrorConstant;
import com.ctp.ghub.model.LoginReqData;
import com.ctp.ghub.model.UserDO;
import com.ctp.ghub.service.UserService;
import com.ctp.ghub.serviceimpl.PasswordEncryptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/20
 */
@Controller
@RequestMapping("/api/ghub/security")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncryptService passwordEncryptService;

    /**
     * 登录
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestBody LoginReqData loginReqData, HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        UserDO userDO = this.userService.selectByAccount(loginReqData.getUserName());
        if(userDO == null){
            modelAndView.addObject("errorMsg", ErrorConstant.ACCOUNT_NOT_EXIST_ERROR.getMessage());
            return modelAndView;
        }
        String encryptPassword = this.passwordEncryptService.encryptPassword(loginReqData.getPassWord(),userDO.getSalt());
        if(!StringUtils.equals(userDO.getPassword(),encryptPassword)){
            modelAndView.addObject("errorMsg", ErrorConstant.ACCOUNT_PWD_ERROR.getMessage());
            return modelAndView;
        }else {
            HttpSession session = request.getSession();
            session.setAttribute(Constant.SESSION_LOGIN_USER,userDO.getAccount());
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }
}
