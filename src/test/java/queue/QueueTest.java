/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package queue;

import com.congfu.model.Blog;
import com.congfu.producer.MessageProducer;
import com.congfu.service.MQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;

/**
 * @author fucong
 * @version $Id QueueTest.java, v 0.1 2017-02-15 下午9:54 fucong Exp $$
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml","classpath:rabbitmq.xml" })
public class QueueTest {

    @Autowired
    private MQProducer mqProducer;
    final String QUEUE_KEY = "test_queue_key";
    @Test
    public void testSendMessage(){
        for (int i =0; i<15; i++){
            Blog blog = new Blog();
            blog.setAuthor("congfu"+i);
            blog.setColor("yellow");
            blog.setTitle("First insert");
            blog.setContent("rr");
            blog.setIsDeleted(0);
            blog.setIsTop(0);
            blog.setUrlName("www.googel.com");
            blog.setCreateMan("你聪哥");
            blog.setCreateTime(new Date());
            blog.setStatus(0);
            mqProducer.sendDataToQueue(QUEUE_KEY,blog);
        }

    }
}

