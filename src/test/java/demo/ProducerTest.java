/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author fucong
 * @version $Id ProducerTest.java, v 0.1 2017-02-15 下午9:17 fucong Exp $$
 */
public class ProducerTest {
    public  static  void  main(String [] args) throws IOException,TimeoutException{
        Producer producer = new Producer("queue");

        for (int i = 0; i< 99999; i++){
            HashMap<String,String> message = new HashMap<String, String>();
            message.put("name","Tom"+i);
            message.put("phone",1886882+i+"");
            producer.sendMessage(message);
            System.out.println("Message Number "+ i+" sent.");
        }
    }
}
