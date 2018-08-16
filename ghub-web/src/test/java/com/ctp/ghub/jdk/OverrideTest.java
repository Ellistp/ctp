package com.ctp.ghub.jdk;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/16
 */
class ParentClass {

    public ParentClass method(int i) {
        System.out.println("ParentClass int: "+i);
        return null;
    }

    public ParentClass method2(int i) {
        System.out.println("ParentClass int: "+i);
        return null;
    }
}

class ChildClass extends ParentClass {

    @Override
    public ChildClass method(int i) {
        System.out.println("ChildClass int: "+i);
        return null;
    }
    //
    //@Override
    //public static ParentClass method2(int i) {
    //    System.out.println("ChildClass int: "+i);
    //    return null;
    //}

    public ChildClass method(Integer i) {
        System.out.println("ChildClass Integer: "+i);
        return null;
    }
}

public class OverrideTest {
    public static void main(String []args){
        ParentClass p = new ParentClass();
        ChildClass c = new ChildClass();
        p.method(1);                  //Parent int: 1
        p.method(new Integer(1));     //Parent int: 1
        c.method(1);                  //Child int: 1
        c.method(new Integer(1));     //Child Integer: 1
    }
}
