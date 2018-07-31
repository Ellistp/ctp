package com.ctp.ghub.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public class RoleDO implements Serializable{

    private static final long serialVersionUID = -2809464732449287918L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String roleName;

    private String roleSign;

    private String description;

    public RoleDO() {
    }

    public RoleDO(Long id, Date gmtCreate, Date gmtModified, String roleName, String roleSign, String description) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.roleName = roleName;
        this.roleSign = roleSign;
        this.description = description;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        RoleDO roleDO = (RoleDO)o;

        return id.equals(roleDO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "RoleDO{" +
            "id=" + id +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", roleName='" + roleName + '\'' +
            ", roleSign='" + roleSign + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
