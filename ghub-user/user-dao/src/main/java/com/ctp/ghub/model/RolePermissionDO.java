package com.ctp.ghub.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public class RolePermissionDO implements Serializable{

    private static final long serialVersionUID = -5841519770536816939L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long roleId;

    private Long permissionId;

    public RolePermissionDO() {
    }

    public RolePermissionDO(Long id, Date gmtCreate, Date gmtModified, Long roleId, Long permissionId) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.roleId = roleId;
        this.permissionId = permissionId;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        RolePermissionDO that = (RolePermissionDO)o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "RolePermissionDO{" +
            "id=" + id +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", roleId=" + roleId +
            ", permissionId=" + permissionId +
            '}';
    }
}
