/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.service;

/**
 * @author fucong
 * @version $Id DubboProducer.java, v 0.1 2017-02-23 下午8:59 fucong Exp $$
 */
public interface DubboProducer {

    /**
     *
     * @param name
     * @return
     */
    public String sayHello(String name);

    /**
     *
     * @param message
     */
    public  void  sendMessage(String message);
}
