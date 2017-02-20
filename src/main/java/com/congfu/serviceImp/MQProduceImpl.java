/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.serviceImp;

import com.congfu.service.MQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fucong
 * @version $Id MQProduceImpl.java, v 0.1 2017-02-16 下午10:37 fucong Exp $$
 */
@Service
public class MQProduceImpl implements MQProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private  final static Logger logger = LoggerFactory.getLogger(MQProduceImpl.class);

    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey,object);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}

























