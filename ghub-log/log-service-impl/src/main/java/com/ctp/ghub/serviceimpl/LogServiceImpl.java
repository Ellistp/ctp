package com.ctp.ghub.serviceimpl;

import java.util.List;

import com.ctp.ghub.dao.LogDao;
import com.ctp.ghub.model.LogDO;
import com.ctp.ghub.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@Service("logService")
public class LogServiceImpl implements LogService{

    @Autowired
    LogDao logDao;

    @Override
    public int insert(LogDO logDO) {
        return logDao.insert(logDO);
    }

    @Override
    public int update(LogDO logDO) {
        return logDao.update(logDO);
    }

    @Override
    public int delete(Long id) {
        return logDao.delete(id);
    }

    @Override
    public LogDO selectById(Long id) {
        return logDao.selectById(id);
    }

    @Override
    public List<LogDO> listAllLogDO() {
        return logDao.listAllLogDO();
    }
}
