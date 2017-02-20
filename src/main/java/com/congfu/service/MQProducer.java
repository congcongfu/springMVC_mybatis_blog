/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.service;

/**
 * @author fucong
 * @version $Id MQProducer.java, v 0.1 2017-02-16 下午10:35 fucong Exp $$
 */
public interface MQProducer {

    /**
     * send message to queue
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object);
}


