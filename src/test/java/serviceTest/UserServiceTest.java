/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package serviceTest;

import com.congfu.model.User;
import com.congfu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author fucong
 * @version $Id UserServiceTest.java, v 0.1 2017-02-23 下午10:30 fucong Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserServiceTest {
    @Autowired
    private UserService userService;

    public User getUser() {
        User user = new User();
        user.setUserName("congcongfu");
        user.setEmail("fudacong@163.com");
        user.setPhoneNumber("18868823392");
        user.setCreateMan("congfu");
        user.setCreateTime(new Date());
        user.setIsDeleted(0);
        user.setVersion(0L);
        user.setPassword("sdfjsj");
        return  user;
    }

    @Test
    public  void testInsert(){
            User user = getUser();
        try {
            int a= userService.insert(user);
            org.junit.Assert.assertTrue(a >0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
