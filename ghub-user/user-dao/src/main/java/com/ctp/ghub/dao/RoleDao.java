package com.ctp.ghub.dao;

import com.ctp.ghub.model.RoleDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public interface RoleDao {

    /**
     * 添加记录
     * @param roleDO
     * @return
     */
    int insert(RoleDO roleDO);

    /**
     * 更新记录
     * @param roleDO
     * @return
     */
    int update(RoleDO roleDO);

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
    RoleDO selectById(Long id);
}
