package com.ctp.ghub.designpattern.factory;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class MailProviderFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
