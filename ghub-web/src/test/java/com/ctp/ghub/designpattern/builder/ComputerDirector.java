package com.ctp.ghub.designpattern.builder;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class ComputerDirector {

    public ComputerProduct produceComputerProduct(ComputerProductBuilder computerProductBuilder){
        computerProductBuilder.buildDisplay();
        computerProductBuilder.buildKayBoard();
        computerProductBuilder.buildMouse();
        return computerProductBuilder.getComputerProduct();
    }
}
