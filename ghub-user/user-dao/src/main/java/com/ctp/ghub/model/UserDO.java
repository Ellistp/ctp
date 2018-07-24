package com.ctp.ghub.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/14
 */
public class UserDO implements Serializable{

    private static final long serialVersionUID = 1846543788430914616L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String account;

    private String password;

    private String salt;

    private String nickName;

    public UserDO() {
    }

    public UserDO(Long id, Date gmtCreate, Date gmtModified, String account, String password, String salt,
                  String nickName) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        UserDO userDO = (UserDO)o;

        return id != null ? id.equals(userDO.id) : userDO.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserDO{" +
            "id=" + id +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", nickName='" + nickName + '\'' +
            '}';
    }
}
