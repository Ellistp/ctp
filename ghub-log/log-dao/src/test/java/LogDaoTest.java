import java.util.List;

import com.ctp.ghub.dao.LogDao;
import com.ctp.ghub.junit.BaseSpringJunitTest;
import com.ctp.ghub.model.LogDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:common-jdbc.xml"})
public class LogDaoTest extends BaseSpringJunitTest {

    @Autowired
    LogDao logDao;

    @Test
    public void testListAllUserDO(){
        List<LogDO> logDOList = logDao.listAllLogDO();
        Assert.assertNotNull(logDOList);
        Assert.assertEquals(logDOList.size(),1);
    }
}
