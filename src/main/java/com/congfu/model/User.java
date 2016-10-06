package com.congfu.model;

import java.util.Date;

import com.congfu.common.BaseModel;

public class User extends BaseModel {

    /**
     * 用户名
     */
    private String  userName;
    /**
     * 密码
     */
    private String  password;
    /**
     * 邮箱
     */
    private String  email;
    /**
     * 登陆次数
     */
    private Integer loginCount;
    /**
     * 最后登陆ip
     */
    private String  lastLoginIp;
    /**
     * 最后登陆时间
     */
    private Date    lastLoginTime;
    /**
     * 登陆key
     */
    private String  authkey;
    /**
     * 是否激活 1 是 2 否
     */
    private Integer active;

    /**
     * 电话号码
     */
    private String  phoneNumber;

    /**
     * 是否删除 1 是 ，0 否
     */
    private Integer isDeleted;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAuthkey() {
        return authkey;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
