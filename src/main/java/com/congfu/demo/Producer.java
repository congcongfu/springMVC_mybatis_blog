/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.demo;

import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * @author fucong
 * @version $Id Producer.java, v 0.1 2017-02-15 下午9:01 fucong Exp $$
 */
public class Producer extends EndPoint{

    public Producer(String endPointName) throws IOException,TimeoutException{
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException{
        channel.basicPublish("",endPointName,null, SerializationUtils.serialize(object));
    }
}

