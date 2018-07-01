package com.ctp.ghub.jdk;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/24
 */
public interface Formula {

    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
