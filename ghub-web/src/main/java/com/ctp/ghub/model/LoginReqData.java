package com.ctp.ghub.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/23
 */
@ApiModel(description="用户登录对象")
public class LoginReqData {

    @ApiModelProperty(value="用户名",name="username")
    private String username;

    @ApiModelProperty(value="密码",name="password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
