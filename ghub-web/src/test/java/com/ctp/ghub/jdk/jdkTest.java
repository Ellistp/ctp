package com.ctp.ghub.jdk;

import java.util.HashSet;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/12
 */
public class jdkTest {

    public static void main(String[] args) {
        // 新建Person对象，
        User p1 = new User("啊啊啊", 26);
        User p2 = new User("啊啊啊", 26);
        User p3 = new User("发发发", 24);

        // 新建HashSet对象
        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        // 比较p1 和 p2， 并打印它们的hashCode()
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        // 打印set
        System.out.printf("set:%s\n", set);
    }

    /**
     * @desc Person类。
     */
    private static class User {
        int age;
        String name;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
        }

        /**
         * @desc 覆盖equals方法
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (this == obj) {
                return true;
            }

            //判断是否类型相同
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            User person = (User)obj;
            return name.equals(person.name) && age == person.age;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + name.hashCode();
            hash = hash * 31 + age;
            return hash;
        }
    }
}
