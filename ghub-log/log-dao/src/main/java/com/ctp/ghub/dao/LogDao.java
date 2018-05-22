package com.ctp.ghub.dao;

import java.util.List;

import com.ctp.ghub.model.LogDO;
import org.springframework.stereotype.Repository;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@Repository
public interface LogDao {

    /**
     * 添加记录
     * @param logDO
     * @return
     */
    int insert(LogDO logDO);

    /**
     * 更新记录
     * @param logDO
     * @return
     */
    int update(LogDO logDO);

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
    LogDO selectById(Long id);

    /**
     * 查询所有user 记录
     * @return
     */
    List<LogDO> listAllLogDO();

}
