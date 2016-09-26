package com.congfu.serviceImp;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.common.CommonServoce;
import com.congfu.dao.StudentDao;
import com.congfu.model.Student;
import com.congfu.service.StudentService;
@Service("studentService")
public class StudentServiceImp extends CommonServoce implements StudentService {

    @Autowired
    private StudentDao studentDao;
    
    static{
        System.out.println("hello spring-mybatis");
    }
    
    public Student findById(int id) throws Exception {
        Student student = new Student();
        try{
            student = studentDao.findById(id);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("根据id查询学生信息失败！id＝"+id + " "+e.getMessage());
            student.setAge(1000);
            student.setName("fuck yourself");
            return student;
        }
        return student;
    }

    @Transactional
    public int insert(Student student) throws Exception {
        int result = 0;
        try{
            result = studentDao.insert(student);
        }catch(Exception e){
            logger.error("新增学生信息失败！"+student.toString());
            throw e;
        }
        return result;
    }

    @Transactional
    public int update(Student student) throws Exception {
        // TODO Auto-generated method stub
        int result = 0;
        try{
            Student student2 = studentDao.findById(student.getId());
            if(student2 != null){
                result = studentDao.update(student);
            }
        }catch(Exception e){
            logger.error("更新学生信息失败！"+student.toString());
            throw e;
        }
        return result;
    }

    public List<Student> findByQuery(Student student) throws Exception {
        // TODO Auto-generated method stub
        List<Student> list = null;
        try{
            list = studentDao.findByQuery(student);
        }catch(Exception e){
            logger.error("条件查询是失败！"+student.toString());
            throw e;
        }
        return list;
    }


}
