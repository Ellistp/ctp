package com.ctp.ghub.enums.log;

/**
 * @author chengtianping
 * @description
 * @date 2018/4/27
 */
public enum OperateTypeEnum {
    ADD("add","新增"),
    UPDATE("update","修改"),
    DELETE("delete","删除"),
    QUERY("query","查询");

    private String code;
    private String name;

    OperateTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
