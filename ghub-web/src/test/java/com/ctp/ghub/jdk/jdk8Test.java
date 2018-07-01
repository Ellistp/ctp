package com.ctp.ghub.jdk;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/23
 */
public class jdk8Test {

    static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    public static void main(String[] args){

        //1.  jdk1.8 允许给接口添加 非抽象的方法 只要使用default 声明即可
        /*
        * interface Formula {
            double calculate(int a);
            default double sqrt(int a) {
            return Math.sqrt(a);
            Formula接口在拥有calculate方法之外同时还定义了sqrt方法，
            实现了Formula接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用。
            }
        }
        * */
        //抽象类 通过实现抽象方法 实现实例化 相当于 子类实现接口的方式
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return 0;
            }
        };

        //2.  lambda 表达式
        // jdk8 之前的排序写法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //jdk8 之后的排序写法
        //将表达式作为 一个参数 传递给方法
        Collections.sort(names,(String a,String b) -> b.compareTo(a));

        //3.  使用 Optional 可以防止空指针的出现
        /* Optional 接口 */
        Optional<List<String>> optionalList = Optional.ofNullable(jdk8Test.names);
        optionalList.ifPresent(name -> System.out.println(name));

        //4.  stream 接口
        //能应用在一组元素上一次执行的操作序列
        /* stream 接口 Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，
        List或者Set， Map不支持。Stream的操作可以串行执行或者并行执行。*/
        Arrays.stream(names.toArray()).filter(name -> StringUtils.equals((String)name,"anna")).forEach(System.out::println);
        //4.1 Filter 过滤
        //4.2 Sort 排序

        //5.  并行Streams
        //前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，
        // 而并行Stream则是在多个线程上同时执行。
        names.parallelStream().filter(name -> StringUtils.equals(name,"anna")).forEach(System.out::println);

        //6. Date API
    }
}
