package com.ctp.ghub.designpattern.builder;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class AcerComputerBuilder implements ComputerProductBuilder{

    ComputerProduct computerProduct = null;

    /**
     * 通过构造函数创建一个ComputerProduct 复杂对象
     */
    public AcerComputerBuilder() {
        computerProduct = new ComputerProduct();
    }

    @Override
    public void buildMouse() {
        computerProduct.setMouse("Acer 牌鼠标");
    }

    @Override
    public void buildKayBoard() {
        computerProduct.setKeyBoard("Acer 牌键盘");
    }

    @Override
    public void buildDisplay() {
        computerProduct.setDisplay("Acer 牌显示器");
    }

    /**
     * 提供完整的产品方法
     * @return
     */
    @Override
    public ComputerProduct getComputerProduct(){
        return computerProduct;
    }
}
