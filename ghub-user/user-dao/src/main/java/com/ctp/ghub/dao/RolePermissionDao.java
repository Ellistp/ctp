package com.ctp.ghub.dao;

import java.util.List;

import com.ctp.ghub.model.RolePermissionDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
public interface RolePermissionDao {

    /**
     * 添加记录
     * @param rolePermissionDO
     * @return
     */
    int insert(RolePermissionDO rolePermissionDO);

    /**
     * 更新记录
     * @param rolePermissionDO
     * @return
     */
    int update(RolePermissionDO rolePermissionDO);

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
    RolePermissionDO selectById(Long id);

    List<RolePermissionDO> selectPermissionsByRoleId(Long roleId);
}
