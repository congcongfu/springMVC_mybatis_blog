/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.controller;

import com.congfu.model.User;
import com.congfu.service.UserProducer;
import com.sun.webkit.dom.StyleSheetImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author fucong
 * @version $Id UserController.java, v 0.1 2017-02-18 下午2:57 fucong Exp $$
 */
@Controller
@RequestMapping("user")
public class UserController {

    private  static  String QUEUE_KEY = "test_queue";
    @Autowired
    private UserProducer userProducer;

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(Model model){
        User user = new User();
        user.setUserName("Tomcat");
        user.setPhoneNumber("18868823392");
        user.setCreateMan("congfu");
        user.setEmail("fudacong@163.com");
        userProducer.sendDataToQueue(QUEUE_KEY,user);
        return "insert";
    }
}
