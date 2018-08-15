package com.ctp.ghub.controller;

import com.ctp.ghub.model.Result;
import com.ctp.ghub.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Api(value="log controller",description="日志操作相关")
@Controller
@RequestMapping("/api/ghub/log")
public class LogController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    LogService logService;

    @RequestMapping(value = "/getLog",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="获取日志",notes="获取相关日志",httpMethod = "GET")
    public Result<String> getLog(){
        logger.info("获取日志信息");
        return Result.createSuccessResult();
    }
}
