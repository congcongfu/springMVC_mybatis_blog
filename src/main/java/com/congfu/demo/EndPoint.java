/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author fucong
 * @version $Id EndPoint.java, v 0.1 2017-02-15 下午8:50 fucong Exp $$
 */
public class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected  String endPointName;

    public  EndPoint(String endpointName) throws IOException,TimeoutException {
        this.endPointName = endpointName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.43.161.130");

        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(endpointName,false,false,false,null);
    }

    public void close() throws  IOException,TimeoutException{
        this.channel.close();
        this.connection.close();
    }
}


