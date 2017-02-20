package com.congfu.controller;

import com.congfu.demo.Producer;
import com.congfu.demo.QueueConsumer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

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
        try {
            Producer producer = new Producer("queue");
            HashMap<String,String> message = new HashMap<String, String>();
            message.put("name","Tom");
            message.put("phone",1886882+"");
            producer.sendMessage(message);
            System.out.println("Message Number sent.");
            producer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "login";
    }
}
