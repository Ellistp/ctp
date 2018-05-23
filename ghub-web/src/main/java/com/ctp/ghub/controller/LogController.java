package com.ctp.ghub.controller;

import com.ctp.ghub.model.LogDO;
import com.ctp.ghub.model.Result;
import com.ctp.ghub.model.UserDO;
import com.ctp.ghub.service.LogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Controller
@RequestMapping("/api/ghub/log")
public class LogController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    LogService logService;

    @RequestMapping(value = "/getLog",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getLog(){
        List<LogDO> logDOList = this.logService.listAllLogDO();
        int size = CollectionUtils.isEmpty(logDOList) == true?0 : logDOList.size();
        logger.info("/api/ghub/log/getLog size:  " + String.valueOf(size));
        return Result.createSuccessResult(String.valueOf(size));
    }
}
