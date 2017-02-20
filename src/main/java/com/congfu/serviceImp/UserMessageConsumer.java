/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.serviceImp;

import com.alibaba.fastjson.JSON;
import com.congfu.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author fucong
 * @version $Id UserMessageConsumer.java, v 0.1 2017-02-18 下午2:51 fucong Exp $$
 */
@Component("userMessageConsumer")
public class UserMessageConsumer implements MessageListener{
    private  static Logger logger = LoggerFactory.getLogger(UserMessageConsumer.class);

    public void onMessage(Message message) {
        try{
            String body = new String(message.getBody(),"UTF-8");
            User user = JSON.parseObject(body,User.class);
            logger.info("**************************************|||||||||******************");
            logger.info("consumer user message success : --> userName:"+user.getUserName());
        }catch (Exception e){
            logger.error("user message consume error : -->"+e.getMessage() );
        }
    }
}

