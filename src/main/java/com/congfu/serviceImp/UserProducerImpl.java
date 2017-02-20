/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.serviceImp;

import com.congfu.model.User;
import com.congfu.service.UserProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fucong
 * @version $Id UserProducerImpl.java, v 0.1 2017-02-18 下午2:46 fucong Exp $$
 */
@Service
public class UserProducerImpl  implements UserProducer{
    private  static Logger logger = LoggerFactory.getLogger(UserProducerImpl.class);
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void sendDataToQueue(String queueKey, User user) {
            try {
                amqpTemplate.convertAndSend(queueKey,user);
                logger.info("send user message success : "+ user.toString());
            }catch (Exception e){
                logger.error("send user message error : "+ user);
            }
    }
}

