package com.ctp.ghub.service;

import com.ctp.ghub.model.UserDO;

import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
public interface UserService {

    /**
     * 添加记录
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);

    /**
     * 更新记录
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询记录
     * @param id
     * @return
     */
    UserDO selectById(Long id);

    /**
     * 查询所有user 记录
     * @return
     */
    List<UserDO> listAllUserDO();
}
