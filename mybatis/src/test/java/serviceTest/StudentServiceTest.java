package serviceTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.dao.StudentDao;
import com.congfu.model.Student;
import com.congfu.service.StudentService;
import com.congfu.util.SerializableTool;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    
    public Student getStudent(){
        Student student = new Student();
        student.setName("Alice");
        student.setAge(22);
        student.setSex("female");
        return student;
    }
    @Test
    public void testFindById(){
        Student student = null;
        try {
            student = studentService.findById(2);
            System.out.println(SerializableTool.serializeFormat(student));
            Assert.assertTrue(student != null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    @Transactional
    public void testInsert(){
        int result = 0;
        try {
            Student student = getStudent();
            result = studentService.insert(student);
            System.out.println(SerializableTool.serializeFormat(student));
            Assert.assertTrue(student.getId() >0);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
            Assert.fail();
        }
    }
    
    @Test
    @Transactional
    public void testUpdate(){
        Student student = getStudent();
        int result = 0;
        try {
            studentService.insert(student);
            System.out.println(SerializableTool.serializeFormat(student));
            student.setAge(23);
            result = studentService.update(student);
            Assert.assertTrue(result >0);
            Student student2 = studentService.findById(student.getId());
            System.out.println(SerializableTool.serializeFormat(student2));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testFindByQuery(){
        Student student = new Student();
        student.setSex("female");
        try {
            long start = System.currentTimeMillis();
            List<Student> list = studentService.findByQuery(student);
            Long cost = System.currentTimeMillis() - start;
            System.out.println(" It takes "+cost + "ms");
            System.out.println(SerializableTool.serializeFormat(list));
            Assert.assertTrue(list.size() > 0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }

}
