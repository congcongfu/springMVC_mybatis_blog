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

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;
    @Autowired
    private Process     process;

    @Transactional(propagation = Propagation.REQUIRED)
    public void update() {
    }

    @Test
    public void testInsert(){
        Blog blog = new Blog();
        blog.setAuthor("congfu");
        blog.setCreateTime(new Date());
        blog.setCreateMan("congfu");
        blog.setUserId(100);
        blog.setTitle("fuck yourslef");
        blog.setColor("white");
        blog.setUrlName("www.googel.com");
        blog.setVersion(1);
        blog.setVersion(0);
        try{
            blogService.insert(blog);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdate() {
        Blog blog = null;
        try {
            blog = blogService.findById(1);
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
