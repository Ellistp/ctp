package com.ctp.ghub.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/31
 */
@Api(value="page controller",description="页面跳转")
@Controller
public class PageController {

    /**
     * 首页
     */
    @RequestMapping("/index")
    @ApiOperation(value="首页",notes="首页跳转",httpMethod = "GET")
    public String index() {
        return "index";
    }

    /**
     * dashboard页
     */
    @RequestMapping("/dashboard")
    @ApiOperation(value="dashboard",notes="dashboard跳转",httpMethod = "GET")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    @ApiOperation(value="404",notes="404跳转",httpMethod = "GET")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    @ApiOperation(value="401",notes="401跳转",httpMethod = "GET")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    @ApiOperation(value="500",notes="500跳转",httpMethod = "GET")
    public String error500() {
        return "500";
    }
}
