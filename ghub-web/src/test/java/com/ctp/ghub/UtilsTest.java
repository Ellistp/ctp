package com.ctp.ghub;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
public class UtilsTest {

    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

        /*
        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
        如果整型字面量的值在-128到127之间，
        那么不会new新的Integer对象，而是直接引用常量池中的Integer对象
        */

        //https://www.cnblogs.com/xiaoxi/p/6036701.html 详解String 类
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());

        /*
        String对象一旦被创建就是固定不变的了，对String对象的任何改变都不影响到原对象，相关的任何change操作都会生成新的对象
        使用字符串常量池。每当我们创建字符串常量时，JVM会首先检查字符串常量池，如果该字符串已经存在常量池中，那么就直接返回常量池中的实例引用。
        如果字符串不存在常量池中，就会实例化该字符串并且将其放到常量池中。
        由于String字符串的不可变性我们可以十分肯定常量池中一定不存在两个相同的字符串（这点对理解上面至关重要）。

        Java中的常量池，实际上分为两种形态：静态常量池和运行时常量池。
        所谓静态常量池，即*.class文件中的常量池，class文件中的常量池不仅仅包含字符串(数字)字面量，还包含类、方法的信息，占用class文件绝大部分空间。
        而运行时常量池，则是jvm虚拟机在完成类装载操作后，将class文件中的常量池载入到内存中，并保存在方法区中，我们常说的常量池，就是指方法区中的运行时常量池
        * */

        String str1="aaa";
        String str2="aaa";
        System.out.println("===========test1============");
        System.out.println(str1==str2);//true 可以看出str1跟str2是指向同一个对象

        String str3=new String("aaa");
        String str4=new String("aaa");
        System.out.println("===========test2============");
        System.out.println(str3==str4);//false 可以看出用new的方式是生成不同的对象
    }
}
