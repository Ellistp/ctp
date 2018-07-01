package com.ctp.ghub.designpattern.builder;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public interface ComputerProductBuilder {

    /**
     * 创建鼠标
     */
    void buildMouse();

    /**
     * 创建键盘
     */
    void buildKayBoard();

    /**
     * 创建显示器
     */
    void buildDisplay();

    /**
     * 获取完整产品
     * @return
     */
    ComputerProduct getComputerProduct();
}
