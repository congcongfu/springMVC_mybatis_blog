package com.congfu.velocity;

import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTest {

    public static void main(String[] args) {
        try {
            VelocityEngine ve = new VelocityEngine();
            Properties properties = new Properties();
            properties.load(Thread.currentThread()
                                  .getContextClassLoader()
                                  .getResourceAsStream("classpath:velocity.properties"));
            ve.init();
            Template template = Velocity.getTemplate("/WEB-INF/wiews/login.vm");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
