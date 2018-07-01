package com.ctp.ghub.designpattern.factory;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class FactoryPatternTest {

    public static void main(String args[]){
        Provider mailProvider = new MailProviderFactory();
        Sender produce = mailProvider.produce();
        produce.send();
    }
}
