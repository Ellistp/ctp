package com.ctp.ghub.designpattern;

/**
 * @author chengtianping
 * @description 单例模式，并且是线程安全的，spring 中的bean 就是单例模式
 * @date 2018/6/29
 */
public class SingletonPattern {

    private static final Singleton singleton = new Singleton();

    private SingletonPattern(){

    }

    public static Singleton getSingleton(){
        return singleton;
    }

    //类中其他方法最好也定义成静态的
}
