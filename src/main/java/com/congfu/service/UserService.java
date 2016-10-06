package com.congfu.service;

import java.util.List;

import com.congfu.model.User;
import com.congfu.query.UserQuery;

public interface UserService {

    /**
     * 新增用户信息
     * 
     * 
     * @param user
     * @return
     * @return int
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public int insert(User user);

    /**
     * 
     * 
     * 
     * @param user
     * @return
     * @return int
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public int update(User user);

    /**
     * 
     * 根据id查询
     * 
     * @param id
     * @return
     * @return User
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public User findById(Long id);

    /**
     * 
     * 条件查询
     * 
     * @param query
     * @return
     * @return List<User>
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public List<User> query(UserQuery query);
}
