package com.ctp.ghub.controller;

import com.ctp.ghub.UserService;
import com.ctp.ghub.model.UserDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Controller
@RequestMapping("/api/ghub/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(){
        List<UserDO> userDOList = this.userService.listAllUserDO();
        int size = CollectionUtils.isEmpty(userDOList) == true?0 : userDOList.size();
        logger.info("/api/ghub/user/getUser size:  " + String.valueOf(size));
        return String.valueOf(size);
    }
}
