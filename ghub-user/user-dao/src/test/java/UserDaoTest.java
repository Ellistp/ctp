import com.ctp.ghub.dao.UserDao;
import com.ctp.ghub.junit.BaseSpringJunitTest;
import com.ctp.ghub.model.UserDO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jdbc/common-jdbc.xml"})
public class UserDaoTest extends BaseSpringJunitTest {

    @Autowired
    UserDao userDao;

    private Long userId = null;

    @Before
    public void insert(){
        UserDO userDO = new UserDO();
        userDO.setAccount("程天平");
        this.userDao.insert(userDO);
        userId = userDO.getId();
    }

    @Test
    public void testSelectById(){
        UserDO userDO = this.userDao.selectById(userId);
        Assert.assertNotNull(userDO);
    }
}
