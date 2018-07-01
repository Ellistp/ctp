package com.ctp.ghub.designpattern.factory;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.print("SmsSender send message !!!");
    }
}
