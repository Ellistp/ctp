package com.ctp.ghub.serviceimpl;

import java.util.List;

import com.ctp.ghub.dao.RolePermissionDao;
import com.ctp.ghub.model.RolePermissionDO;
import com.ctp.ghub.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public int insert(RolePermissionDO rolePermissionDO) {
        return rolePermissionDao.insert(rolePermissionDO);
    }

    @Override
    public int update(RolePermissionDO rolePermissionDO) {
        return rolePermissionDao.update(rolePermissionDO);
    }

    @Override
    public int delete(Long id) {
        return rolePermissionDao.delete(id);
    }

    @Override
    public RolePermissionDO selectById(Long id) {
        return rolePermissionDao.selectById(id);
    }

    @Override
    public List<RolePermissionDO> selectPermissionsByRoleId(Long roleId) {
        return this.rolePermissionDao.selectPermissionsByRoleId(roleId);
    }
}
