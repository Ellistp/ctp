package com.ctp.ghub.designpattern.builder;

/**
 * Created by Administrator on 2018/7/1 0001.
 * 复杂对象的组成部分，为了方便演示，里面的组成部分都用String 类型代替 各自的类型了
 */
public class ComputerProduct {

    /**
     * 鼠标
     */
    private String mouse;

    /**
     * 键盘
     */
    private String keyBoard;

    /**
     * 显示器
     */
    private String display;

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "ComputerProduct{" +
                "mouse='" + mouse + '\'' +
                ", keyBoard='" + keyBoard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
