package com.ctp.ghub.model;

import java.io.Serializable;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/21
 */
public class MessageEntity implements Serializable{

    private static final long serialVersionUID = -1835498589268357306L;

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
