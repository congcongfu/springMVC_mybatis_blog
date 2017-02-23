/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fucong
 * @version $Id DubboTest.java, v 0.1 2017-02-23 下午9:15 fucong Exp $$
 */
public class DubboTest {
    public static  void   main(String [] args) throws  Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.start();
        System.in.read();
    }
}

