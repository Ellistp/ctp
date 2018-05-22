package com.ctp.ghub.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
public class LogDO implements Serializable{

    private static final long serialVersionUID = 1846393788430914616L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    /**
     * 操作人id
     */
    private Long userId;

    /**
     * 操作模块
     */
    private String moduleName;

    private String ip;

    private String url;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 操作状态
     */
    private Integer operateStatus;

    /**
     * 操作形容
     */
    private String operateDesc;

    public LogDO() {
    }

    public LogDO(Long id, Date gmtCreate, Date gmtModified, Long userId, String moduleName, String ip, String url,
                 String operateType, Integer operateStatus, String operateDesc) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.userId = userId;
        this.moduleName = moduleName;
        this.ip = ip;
        this.url = url;
        this.operateType = operateType;
        this.operateStatus = operateStatus;
        this.operateDesc = operateDesc;
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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public Integer getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Integer operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        LogDO logDO = (LogDO)o;

        return id.equals(logDO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "LogDO{" +
            "id=" + id +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", userId=" + userId +
            ", moduleName='" + moduleName + '\'' +
            ", ip='" + ip + '\'' +
            ", url='" + url + '\'' +
            ", operateType='" + operateType + '\'' +
            ", operateStatus=" + operateStatus +
            ", operateDesc='" + operateDesc + '\'' +
            '}';
    }
}
