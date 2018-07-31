package com.ctp.ghub.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public class PermissionDO implements Serializable{

    private static final long serialVersionUID = -5777796211457240819L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String permissionName;

    private String permissionSign;

    private String description;

    public PermissionDO() {
    }

    public PermissionDO(Long id, Date gmtCreate, Date gmtModified, String permissionName, String permissionSign,
                        String description) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.permissionName = permissionName;
        this.permissionSign = permissionSign;
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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionSign() {
        return permissionSign;
    }

    public void setPermissionSign(String permissionSign) {
        this.permissionSign = permissionSign;
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

        PermissionDO that = (PermissionDO)o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PermissionDO{" +
            "id=" + id +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", permissionName='" + permissionName + '\'' +
            ", permissionSign='" + permissionSign + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
