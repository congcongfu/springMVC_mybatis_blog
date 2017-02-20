/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author fucong
 * @version $Id MessageProducer.java, v 0.1 2017-02-14 下午10:15 fucong Exp $$
 */
@Service("messageProducer")
public class MessageProducer {

    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message){
        logger.info("to send message : {}" ,message);
        amqpTemplate.convertAndSend("queueTestKey",message);
    }

}


















