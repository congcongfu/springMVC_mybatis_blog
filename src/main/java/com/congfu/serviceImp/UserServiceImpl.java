package com.congfu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congfu.dao.UserDao;
import com.congfu.model.User;
import com.congfu.query.UserQuery;
import com.congfu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int insert(User user) {
        // 参数校验
        return userDao.insert(user);
    }

    public int update(User user) {
        int result = 0;
        User oldUser = userDao.findById((long) user.getId());
        if (oldUser != null) {
            try {
                result = userDao.update(user);
            } catch (Exception e) {
                // TODO: handle exception
                throw new RuntimeException("更新用户信息出错 ==> id=" + user.getId());
            }
        }
        return result;
    }

    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userDao.findById(id);
    }

    public List<User> query(UserQuery query) {
        // TODO Auto-generated method stub
        return userDao.query(query);
    }

}
