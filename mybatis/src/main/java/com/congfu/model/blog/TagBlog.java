package com.congfu.model.blog;

import java.util.Date;

import com.congfu.common.BaseModel;

public class TagBlog extends BaseModel {
    /**
     * 标签id
     */
    private Integer tagId;
    /**
     *博客id 
     */
    private Integer blogId;
    /**
     * 博客状态
     */
    private Integer blogStatus;
    /**
     * 发布时间
     */
    private Date publshTime;
    public Integer getTagId() {
        return tagId;
    }
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
    public Integer getBlogId() {
        return blogId;
    }
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
    public Integer getBlogStatus() {
        return blogStatus;
    }
    public void setBlogStatus(Integer blogStatus) {
        this.blogStatus = blogStatus;
    }
    public Date getPublshTime() {
        return publshTime;
    }
    public void setPublshTime(Date publshTime) {
        this.publshTime = publshTime;
    }
}
