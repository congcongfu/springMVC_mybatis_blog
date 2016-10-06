package com.congfu.query;

import java.util.Date;

import com.congfu.model.User;

public class UserQuery extends User {

    private Date createTimeBegin;

    private Date createTimeEnd;

    private Date lastLoginTimeBegin;

    private Date lastLoginTimeEnd;

    public Date getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Date getLastLoginTimeBegin() {
        return lastLoginTimeBegin;
    }

    public void setLastLoginTimeBegin(Date lastLoginTimeBegin) {
        this.lastLoginTimeBegin = lastLoginTimeBegin;
    }

    public Date getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }

    public void setLastLoginTimeEnd(Date lastLoginTimeEnd) {
        this.lastLoginTimeEnd = lastLoginTimeEnd;
    }

}
