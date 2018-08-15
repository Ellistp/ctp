package com.ctp.ghub.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/21
 */
@ApiModel(value="MessageEntity", discriminator = "foo", subTypes = {MessageEntity.class})
public class MessageEntity implements Serializable{

    private static final long serialVersionUID = -1835498589268357306L;

    @ApiModelProperty(value="手机号",name="phone")
    private String phone;

    public MessageEntity(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
