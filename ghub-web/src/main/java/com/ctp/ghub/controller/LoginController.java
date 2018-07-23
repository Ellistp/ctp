package com.ctp.ghub.controller;

import java.io.IOException;

import com.ctp.ghub.model.LoginReqData;
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

    /**
     * 登录
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestBody LoginReqData loginReqData) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
