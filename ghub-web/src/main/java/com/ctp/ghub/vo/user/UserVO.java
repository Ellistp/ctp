package com.ctp.ghub.vo.user;

/**
 * @author chengtianping
 * @description
 * @date 2018/6/28
 */
public class UserVO {

    private Long id;

    private String name;

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

    @Override
    public String toString() {
        return "UserVO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
