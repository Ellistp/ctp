package com.ctp.ghub.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author chengtianping
 * @description
 * @date 2018/6/12
 */
public class TestDO implements Serializable{

    private static final long serialVersionUID = 1846543788987314616L;

    private Long id;
    private String name;
    private String sex;

    public TestDO() {
    }

    public TestDO(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        //首先writeObject()调用了默认的序列化方法defaultWriteObject()来处理非transient域
        //id name sex
        //objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(name);
        objectOutputStream.writeObject(sex);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        //调用defaultReadObject()方法，将非transient域id、name和sex从流中读出；
        //objectInputStream.defaultReadObject();
        name = (String)objectInputStream.readObject();
        sex = (String)objectInputStream.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        TestDO testDO = (TestDO)o;

        return id.equals(testDO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TestDO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            '}';
    }
}
