package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.model.Blog;
import com.congfu.model.User;
import com.congfu.service.BlogService;
import com.congfu.service.Process;
import com.congfu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;
    @Autowired
    private Process     process;
    @Autowired
    private UserService userService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void update() {
        try {
            process.myAction();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        User user = userService.findById(1l);
        user.setUpdateMan("fu cong");
        user.setEmail("fuckyou@123.com");
        userService.update(user);
    }

    @Test
    public void testUpdate() {
        Blog blog = null;
        try {
            blog = blogService.findById(1L);
            System.out.println(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testProcessUpdate() {
        try {
            update();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
