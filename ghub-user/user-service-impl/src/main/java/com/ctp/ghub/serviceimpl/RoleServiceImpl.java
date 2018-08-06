package com.ctp.ghub.serviceimpl;

import com.ctp.ghub.dao.RoleDao;
import com.ctp.ghub.model.RoleDO;
import com.ctp.ghub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public int insert(RoleDO roleDO) {
        return roleDao.insert(roleDO);
    }

    @Override
    public int update(RoleDO roleDO) {
        return roleDao.update(roleDO);
    }

    @Override
    public int delete(Long id) {
        return roleDao.delete(id);
    }

    @Override
    public RoleDO selectById(Long id) {
        return roleDao.selectById(id);
    }
}
