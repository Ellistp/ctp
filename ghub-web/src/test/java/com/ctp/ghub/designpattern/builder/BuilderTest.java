package com.ctp.ghub.designpattern.builder;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class BuilderTest {

    public static void main(String args[]){
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerProduct computerProduct = computerDirector.produceComputerProduct(new AcerComputerBuilder());
        System.out.print(computerProduct.toString());
    }
}
