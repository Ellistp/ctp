package com.ctp.ghub.mq.model;

import java.io.Serializable;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/21
 */
public class MessageEntity implements Serializable{

    private static final long serialVersionUID = -1835498589268357306L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
            "message='" + message + '\'' +
            '}';
    }
}
