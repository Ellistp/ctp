package com.ctp.ghub.controller;

import com.ctp.ghub.model.UserDO;
import com.ctp.ghub.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/12 0012.
 */

@Api(value="user")
@Controller
@RequestMapping("/api/ghub/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    @ApiOperation(value="根据ID获取用户信息",httpMethod="GET",notes="get user by id",response=UserDO.class)
    public UserDO getUser(@ApiParam(required=true,value="用户ID",name="userId")@RequestParam(value="userId")Long userId) {
        logger.info("根据ID获取用户信息");
        return userService.selectById(userId);
    }

}
