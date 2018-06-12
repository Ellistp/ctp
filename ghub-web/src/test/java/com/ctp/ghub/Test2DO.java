package com.ctp.ghub;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author chengtianping
 * @description
 * @date 2018/6/12
 */
public class Test2DO implements Externalizable {

    private static final long serialVersionUID = 1846543788987387216L;

    private Long id;
    private String name;
    private String sex;

    public Test2DO() {
    }

    public Test2DO(Long id, String name, String sex) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Test2DO test2DO = (Test2DO)o;

        return id != null ? id.equals(test2DO.id) : test2DO.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //首先writeObject()调用了默认的序列化方法defaultWriteObject()来处理非transient域
        //id name sex
        //objectOutputStream.defaultWriteObject();
        out.writeObject(name);
        out.writeObject(sex);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //调用defaultReadObject()方法，将非transient域id、name和sex从流中读出；
        //objectInputStream.defaultReadObject();
        name = (String)in.readObject();
        sex = (String)in.readObject();
    }

    @Override
    public String toString() {
        return "Test2DO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            '}';
    }
}
