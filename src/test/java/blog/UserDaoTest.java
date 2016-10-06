package blog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.dao.UserDao;
import com.congfu.model.User;
import com.congfu.query.UserQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    private User getUser() {
        User user = new User();
        user.setUserName("Eric");
        user.setAuthkey("SZHGJEJDK/@$fsk");
        user.setIsDeleted(0);
        user.setEmail("congcongfu@163.com");
        user.setPhoneNumber("18868823392");
        user.setCreateMan("congfu");
        return user;
    }

    @Test
    public void testInsert() {
        User user = getUser();
        try {
            int a = userDao.insert(user);
            Assert.assertTrue(a > 0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void testUpdate() {
        User user = null;
        try {
            user = getUser();
            int a = userDao.insert(user);
            user.setEmail("fuck hard");
            userDao.update(user);
            user = userDao.findById((long) user.getId());

            Assert.assertTrue(a > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery() {
        List<User> userList = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date createTimeBegin = null;
        Date createTimeEnd = null;
        try {
            createTimeBegin = format.parse("2016-09-30 23:40:38");
            createTimeEnd = format.parse("2016-10-02 22:40:38");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserQuery query = new UserQuery();
        query.setCreateTimeBegin(createTimeBegin);
        query.setCreateTimeEnd(createTimeEnd);
        try {
            userList = userDao.query(query);
            System.out.println(userList.size());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
