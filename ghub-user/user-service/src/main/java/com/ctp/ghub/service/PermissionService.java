package com.ctp.ghub.service;

import com.ctp.ghub.model.PermissionDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public interface PermissionService {

    /**
     * 添加记录
     * @param permissionDO
     * @return
     */
    int insert(PermissionDO permissionDO);

    /**
     * 更新记录
     * @param permissionDO
     * @return
     */
    int update(PermissionDO permissionDO);

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
    PermissionDO selectById(Long id);
}
