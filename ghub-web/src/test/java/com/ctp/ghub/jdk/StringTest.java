package com.ctp.ghub.jdk;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/2
 */
public class StringTest {

    public static void main(String args[]){
        String str1 = "test";
        String str2 = new String("test2");
        String str3 = str2;
        String str4 = str1;
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str4);
        System.out.println(str4 == str2);


        String s1= "ab" + "cd";
        String s2= "abc" + "d";
        System.out.println(s1 == s2);
    }
}
