package com.ctp.ghub.service;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public interface SmsMessageService {

    /**
     * 平台产生验证码
     */
    String generateVerifyCode(String smsMessageType,String mobile, int length);

    /**
     * 发送短信--指定短信内容
     */
    void send(String smsMessageType,String mobile, String content);
}
