package com.ctp.ghub.controller;

import com.ctp.ghub.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Controller
@RequestMapping("/api/ghub/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(){
        return "chengtianping";
    }
}
