package com.ctp.ghub;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/23
 */
public class jdk8Test {

    static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    public static void main(String[] args){

        //jdk8 之前的排序写法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //jdk8 之后的排序写法
        Collections.sort(names,(String a,String b) -> b.compareTo(a));

        /* Optional 接口 */
        Optional<List<String>> optionalList = Optional.ofNullable(jdk8Test.names);
        optionalList.ifPresent(name -> System.out.println(name));

        /* stream 接口 Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，
        List或者Set， Map不支持。Stream的操作可以串行执行或者并行执行。*/
        Arrays.stream(names.toArray()).filter(name -> StringUtils.equals((CharSequence)name,"anna")).forEach(System.out::println);
    }
}
