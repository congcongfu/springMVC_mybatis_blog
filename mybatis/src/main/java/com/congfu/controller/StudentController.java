package com.congfu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congfu.model.Student;
import com.congfu.service.StudentService;
import com.congfu.util.ResponseUtils;

@Controller
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @RequestMapping("insert")
    public void insert(HttpServletRequest httpRequest, HttpServletResponse response) throws Exception{
        Student student = new Student();
        student.setAge(11);
        student.setName("Erics");
        student.setSex("male");
        int result = studentService.insert(student);
        
        ResponseUtils.renderJson(response, String.valueOf(result));
    }
    
    @RequestMapping("findStudent")
    @ResponseBody
    public void findStudent(HttpServletRequest request,HttpServletResponse response, 
        @RequestParam Integer id) throws Exception{
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map);
        Student student = new Student();
        student = studentService.findById(id);
        ResponseUtils.renderJson(response, student.toString());
    }
}
