package com.ctp.ghub.serviceimpl;

import com.ctp.ghub.dao.PermissionDao;
import com.ctp.ghub.model.PermissionDO;
import com.ctp.ghub.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/7/25
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public int insert(PermissionDO permissionDO) {
        return permissionDao.insert(permissionDO);
    }

    @Override
    public int update(PermissionDO permissionDO) {
        return permissionDao.update(permissionDO);
    }

    @Override
    public int delete(Long id) {
        return permissionDao.delete(id);
    }

    @Override
    public PermissionDO selectById(Long id) {
        return permissionDao.selectById(id);
    }
}
