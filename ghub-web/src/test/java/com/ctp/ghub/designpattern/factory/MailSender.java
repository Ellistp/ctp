package com.ctp.ghub.designpattern.factory;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.print("MailSender send message !!!");
    }
}
