/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.demo;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author fucong
 * @version $Id QueueConsumer.java, v 0.1 2017-02-15 下午9:05 fucong Exp $$
 */
public class QueueConsumer extends EndPoint implements Runnable,Consumer{

    public QueueConsumer(String endPointName) throws  IOException,TimeoutException{
        super(endPointName);
    }

    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+ consumerTag + " registered");
    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] body) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(body);
        System.out.println("Message Number "+map.get("name")+ " "+map.get("phone")+" received");
    }

    public void run() {

        try{
            channel.basicConsume(endPointName,true,this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


