/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author fucong
 * @version $Id Test.java, v 0.1 2017-02-15 下午9:14 fucong Exp $$
 */
public class Test {
    public  static void main(String [] args)throws IOException,TimeoutException{
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}

