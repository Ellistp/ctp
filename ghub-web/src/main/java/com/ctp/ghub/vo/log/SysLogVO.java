package com.ctp.ghub.vo.log;

/**
 * @author chengtianping
 * @description
 * @date 2018/6/28
 */
public class SysLogVO {

    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String toString() {
        return "SysLogVO{" +
            "id=" + id +
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
