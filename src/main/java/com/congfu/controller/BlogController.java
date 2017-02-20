/**
 * Company
 * Copyright (C) 2004-2016 All Rights Reserved.
 */
package com.congfu.controller;

import com.congfu.model.Blog;
import com.congfu.query.BlogQuery;
import com.congfu.service.BlogService;
import com.congfu.service.MQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * @author fucong
 * @version $Id BlogController.java, v 0.1 2016-11-20 下午7:23 fucong Exp $$
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    private static String QUEUE_KEY="test_queue_key";
    @Autowired
    private BlogService blogService;
    @Autowired
    private MQProducer mqProducer;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        BlogQuery query = new BlogQuery();
        List<Blog> blogs = blogService.query(query);
        System.out.println("fuck");
        model.put("title", "velocity test");
        model.put("content", "my content");
        return "blog/blog_list";
    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insertUser(){
        Blog blog = new Blog();
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
        blog.setVersion(0);
        mqProducer.sendDataToQueue(QUEUE_KEY,blog);
        return "insert";
    }
}
