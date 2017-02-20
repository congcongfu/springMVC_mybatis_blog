/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.consumer;

import com.congfu.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fucong
 * @version $Id MessageConsumer.java, v 0.1 2017-02-14 下午10:14 fucong Exp $$
 */
@Service
public class MessageConsumer implements MessageListener{

    private AmqpTemplate amqpTemplate;
    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    public void onMessage(Message message) {
        logger.info("receive message : {}",message);
    }

    public  void  popMessage(String destinationQueueName){
        Message message = amqpTemplate.receive(destinationQueueName);
        logger.info(new String(message.getBody()));
    }
}
