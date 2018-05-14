package com.ctp.ghub.dao;

import com.ctp.ghub.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Mapper
public interface UserDao {

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
}
