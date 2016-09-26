package com.congfu.service;

import java.util.List;

import com.congfu.model.Student;

public interface StudentService {
    /**
     * 根据主键id查询
     * 
     * @param student id
     * @return
     * @return Student
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月3日
     * </PRE>
     */
    public Student findById(int id) throws Exception;
    
    /**
     * 
     * 新增
     * 
     * @param student
     * @return
     * @return int 
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月3日
     * </PRE>
     */
    public int insert(Student student) throws Exception;
    
    /**
     * 更新学生信息
     * 
     * @param student
     * @return
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月3日
     * </PRE>
     */
    public int update(Student student) throws Exception;
    
    /**
     * 根据条件查询
     * 
     * 
     * @param student 学生信息
     * @return List<Student>
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月3日
     * </PRE>
     */
    public List<Student> findByQuery(Student student) throws Exception;
}
