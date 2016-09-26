package com.congfu.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.dao.StudentDao;
import com.congfu.model.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class MybatisTest {
    @Autowired
    private StudentDao studentDao;
    
    public Student getStudent(){
        Student student = new Student();
        student.setName("Fuck");
        student.setAge(22);
        student.setSex("male");
        return student;
    }
    
    @Test
    public void test1(){
        System.out.println("Hello world");
    }
    
    @Test
    public void testFindById(){
        Student student = new Student();
        try{
            student = studentDao.findById(2);
            System.out.println(student);
            Assert.assertTrue(student.getId() >0);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    @Transactional
    public void testInsert(){
        Student student = getStudent();
        try{
            int i = studentDao.insert(student);
            System.out.println(student.getId());
            Assert.assertTrue(student.getId() >0);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    @Transactional
    public void testUpdate(){
        Student student = getStudent();
        try{
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
            Assert.assertTrue(a >0);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
