package com.congfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("get")
    public String getMessage() {
        String result = "Hello world";
        System.out.println("hello");
        return result;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        System.out.println("fuck");
        model.put("title", "velocity test");
        model.put("content", "my content");
        return "login";
    }
}
