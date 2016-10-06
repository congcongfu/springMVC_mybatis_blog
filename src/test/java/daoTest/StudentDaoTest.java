package daoTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.common.Result;
import com.congfu.constant.Constant;
import com.congfu.dao.StudentDao;
import com.congfu.model.Student;
import com.congfu.util.SerializableTool;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class StudentDaoTest {

    @Autowired
    private StudentDao    studentDao;
    private static Logger logger = Logger.getRootLogger();

    public Student getStudent() {
        Student student = new Student();
        student.setName("Fuck");
        student.setAge(22);
        student.setSex("male");
        return student;
    }

    @Test
    public void test1() {
        System.out.println("Hello world");
    }

    @Test
    public void testFindById() {
        Student student = new Student();
        try {
            student = studentDao.findById(1);
            System.out.println(student);
            Assert.assertTrue(student.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
//    @Transactional
    public void testInsert() {
        Student student = getStudent();
        student.setName("你三个哥");
        try {
            int i = studentDao.insert(student);
            Student student2 = studentDao.findById(student.getId());
            System.out.println(SerializableTool.serializeFormat(student2));
            Assert.assertTrue(student.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    @Transactional
    public void testUpdate() {
        Student student = getStudent();
        try {
            System.out.println(student);
            studentDao.insert(student);
            student = studentDao.findById(student.getId());
            System.out.println(student);
            student.setName("gg");
            student.setAge(22);
            student.setSex("female");
            int a = studentDao.update(student);
            student = studentDao.findById(student.getId());
            System.out.println(student);
            Assert.assertTrue(a > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testFindByQuery() {
        List<Student> list = new ArrayList<Student>();
        Student student = new Student();
        student.setId(2);
//        student.setName("To");
//        student.setAge(11);
//        student.setSex("male");
        try {
            list = studentDao.findByQuery(student);
            Result<List<Student>> result = new Result<List<Student>>();
            result.setData(list);
            result.setMessage("查询成功！");
            result.setStatus(Constant.SUCCESS_STATUS);
            String text = SerializableTool.serializeFormat(result);
            System.out.println(text);
            Assert.assertTrue(list.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
