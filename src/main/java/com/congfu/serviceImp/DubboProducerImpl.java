/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.serviceImp;

import com.congfu.service.DubboProducer;
import org.springframework.stereotype.Service;

/**
 * @author fucong
 * @version $Id DubboProducerImpl.java, v 0.1 2017-02-23 下午9:01 fucong Exp $$
 */
@Service("dubboProducer")
public class DubboProducerImpl implements DubboProducer{
    public String sayHello(String name) {
        return "Hello dubbo";
    }

    public void sendMessage(String message) {
        System.out.println("Say Hello Dubbo !");
    }
}