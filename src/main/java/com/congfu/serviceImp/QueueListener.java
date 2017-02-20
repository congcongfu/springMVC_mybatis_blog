/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.serviceImp;

import com.alibaba.fastjson.JSON;
import com.congfu.model.Blog;
import com.congfu.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fucong
 * @version $Id QueueListener.java, v 0.1 2017-02-16 下午10:42 fucong Exp $$
 */
@Component("queueListenter")
public class QueueListener implements MessageListener{
    private  static Logger logger = LoggerFactory.getLogger(QueueListener.class);
    @Autowired
    private BlogService blogService;
    public void onMessage(Message message) {
        try {
            String  body = new String(message.getBody(),"UTF-8");
            Blog blog = JSON.parseObject(body,Blog.class);
            blogService.insert(blog);
            logger.info("*********************************|||||||********************");
            logger.info("consumer message success --> blog_id : " + blog.getId());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}

