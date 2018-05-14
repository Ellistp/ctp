package com.ctp.ghub.controller;

import com.ctp.ghub.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Controller
@RequestMapping("/api/ghub/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(){
        String name = userService.selectById(1L).getName();
        return name;
    }
}
