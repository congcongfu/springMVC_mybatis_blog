package blog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.congfu.dao.BlogDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.congfu.model.Blog;
import com.congfu.query.BlogQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class BlogDaoTest {

    @Autowired
    private BlogDao blogDao;

    @Test
    public void testInsert() {
        System.out.println(new Date());
        Blog blog = new Blog();
        blog.setUserId(4);
        blog.setAuthor("congfu");
        blog.setColor("yellow");
        blog.setTitle("First insert");
        blog.setContent("rr");
        blog.setIsDeleted(0);
        blog.setIsTop(0);
        blog.setUrlName("www.googel.com");
        blog.setCreateMan("你聪哥");
        blog.setCreateTime(new Date());
        blog.setStatus(0);
        try {
            int a = blogDao.insert(blog);
            Assert.assertTrue(a > 0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testFindById() {
        Blog blog = new Blog();
        try {
            blog = blogDao.selectById(1);
            System.out.println(blog);
            Assert.assertTrue(blog.getId() > 0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testQuery() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date publishTimeBegin = null;
        Date publishTImeEnd = null;
        try {
            publishTimeBegin = format.parse("2016-09-26 23:40:38");
            publishTImeEnd = format.parse("2016-09-28 22:40:38");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        BlogQuery query = new BlogQuery();
        query.setTitle("second ");
//        query.setCreateTimeBegin(publishTimeBegin);
//        query.setCreateTimeEnd(publishTImeEnd);
        query.setAuthor("cong");
        List<Blog> list = new ArrayList<Blog>();
        try {
//            list = blogDao.query(query);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {
        Blog blog = null;
        try {
            blog = blogDao.selectById(1);
            blog.setUpdateMan("宛燕");
            blog.setUpdateTime(new Date());
            blog.setTags("标签");
            blog.setTitle("博客");
            blog.setIsDeleted(0);
            blog.setIsTop(1);
            int result = blogDao.updateByPrimaryKeyWithBLOBs(blog);
            Assert.assertTrue(result > 0);
            blog = blogDao.selectById(1);
            System.out.println(blog);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
}
