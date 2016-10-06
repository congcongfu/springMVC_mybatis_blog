package blog;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.congfu.dao.TagDao;
import com.congfu.model.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TagDaoTest {

    @Autowired
    private TagDao tagDao;

    private Tag getTag() {
        Tag tag = new Tag();
        tag.setName("Java");
        tag.setIsDeleted(0);
        tag.setCount(0);
        tag.setCreateMan("Eric cong");
        return tag;
    }

    @Test
    public void testInsert() {
        Tag tag = getTag();
        try {
            int a = tagDao.insert(tag);
            Assert.assertTrue(a > 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void updateTest() {
        Tag tag = null;
        try {
            tag = tagDao.findById(1l);
            tag.setName("fuck update");
            tag.setUpdateMan("Eric");
            tag.setUpdateTime(new Date());
            int a = tagDao.update(tag);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
