package com.congfu.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.congfu.model.Blog;
import com.congfu.model.Tag;
import com.congfu.model.User;
import com.congfu.service.BlogService;
import com.congfu.service.Process;

@Service("process")
public class ProcessImpl implements Process {


    @Autowired
    private BlogService blogService;

    @Transactional(readOnly = true, propagation = Propagation.NESTED)
    public void myAction() {
        try {
            this.doAction();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public void doAction() {
        Blog blog = blogService.findById(1);
        blog.setColor("yellow");
        blog.setUpdateMan("fu cong");
        blogService.update(blog);

//        Tag tag = tagService.findById(1L);
//        tag.setUpdateMan("hellow test");
//        tag.setUpdateTime(new Date());
//        tagService.update(tag);

    }

    @Transactional
    public void transactionAction() {
//        User user = userService.findById(1l);
//        user.setUpdateMan("fu cong");
//        user.setEmail("googel@123.com");
//        userService.update(user);
        try {
            this.myAction();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
