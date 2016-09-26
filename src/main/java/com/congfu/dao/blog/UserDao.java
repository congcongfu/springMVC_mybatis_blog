package com.congfu.dao.blog;

import java.util.List;


import com.congfu.model.blog.User;

public interface UserDao {
    /**
     * 
     * 新增用户
     * 
     * @param user
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public int insert(User user);
    /**
     * 
     * 修改用户信息
     * 
     * @param user
     * @return
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public int update(User user);
    /**
     * 
     * 根据用户id查找
     * 
     * @param id
     * @return User
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public User findById(Long id);
    /**
     * 条件查询
     * 
     * @param user
     * @return
     * @return List<User>
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public List<User> query(User user);

    public  User findByPhone(Long number);
}
