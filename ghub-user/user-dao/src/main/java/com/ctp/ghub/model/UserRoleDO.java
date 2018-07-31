package com.ctp.ghub.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public class UserRoleDO implements Serializable{

    private static final long serialVersionUID = -4452251716759370041L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long userId;

    private Long roleId;

    public UserRoleDO() {
    }

    public UserRoleDO(Long id, Date gmtCreate, Date gmtModified, Long userId, Long roleId) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.userId = userId;
        this.roleId = roleId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        UserRoleDO that = (UserRoleDO)o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "UserRoleDO{" +
            "id=" + id +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", userId=" + userId +
            ", roleId=" + roleId +
            '}';
    }
}
