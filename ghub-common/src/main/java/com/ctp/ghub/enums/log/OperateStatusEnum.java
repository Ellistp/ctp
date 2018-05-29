package com.ctp.ghub.enums.log;

/**
 * @author chengtianping
 * @description
 * @date 2018/4/27
 */
public enum OperateStatusEnum {
    SUCCESS(1,"成功"),
    FAILURE(0,"失败");

    private Integer code;
    private String desc;

    OperateStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
