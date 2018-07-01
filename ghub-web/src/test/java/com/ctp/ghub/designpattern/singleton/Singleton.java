package com.ctp.ghub.designpattern.singleton;

/**
 * Created by Administrator on 2018/6/30 0030.
 */
public class Singleton {

    //确保当前类不能够被实例化
    private Singleton(){
    }

    //内部类来实例化该对象
    private static class SingletonFactory{
        private static final Singleton singleton = new Singleton();
    }

    //获取实例
    public static Singleton getSingleton(){
        return SingletonFactory.singleton;
    }
}
