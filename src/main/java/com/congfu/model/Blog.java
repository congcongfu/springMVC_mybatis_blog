/**
 * Blog.java
 * Copyright(C) 
 * All rights reserved
 * ---------------------------------------
 * 2016-11-19 :22:11:238 Created
 */
package com.congfu.model;

import java.util.Date;

public class Blog {
    /** 主键id */
    private Integer id;

    /** 用户id */
    private Integer userId;

    /** 作者 */
    private String author;

    /** 标题 */
    private String title;

    /** 颜色 */
    private String color;

    /** url连接 */
    private String urlName;

    /** url类型 */
    private String urlType;

    /** 标签 */
    private String tags;

    /** 是否删除 1 是 0 否 */
    private Integer isDeleted;

    /** 是否置顶 */
    private Integer isTop;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private String createMan;

    /** 修改时间 */
    private Date updateTime;

    /** 修改人 */
    private String updateMan;

    /** 版本 */
    private Integer version;

    /** 浏览次数 */
    private Integer view;

    /** 发布状态 */
    private Integer status;

    /** 发布时间 */
    private Date publishTime;

    /** 内容 */
    private String content;

    /**
     * 
     *  主键id,所属表字段为blog.id
     *
     * @return the value of blog.id
     */
    public Integer getId() {
        return id;
    }

    /**
    blog.id
     *
     * @param id the value for blog.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     *  用户id,所属表字段为blog.user_id
     *
     * @return the value of blog.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
    blog.user_id
     *
     * @param userId the value for blog.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     *  作者,所属表字段为blog.author
     *
     * @return the value of blog.author
     */
    public String getAuthor() {
        return author;
    }

    /**
    blog.author
     *
     * @param author the value for blog.author
     *
     * @mbg.generated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 
     *  标题,所属表字段为blog.title
     *
     * @return the value of blog.title
     */
    public String getTitle() {
        return title;
    }

    /**
    blog.title
     *
     * @param title the value for blog.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 
     *  颜色,所属表字段为blog.color
     *
     * @return the value of blog.color
     */
    public String getColor() {
        return color;
    }

    /**
    blog.color
     *
     * @param color the value for blog.color
     *
     * @mbg.generated
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * 
     *  url连接,所属表字段为blog.url_name
     *
     * @return the value of blog.url_name
     */
    public String getUrlName() {
        return urlName;
    }

    /**
    blog.url_name
     *
     * @param urlName the value for blog.url_name
     *
     * @mbg.generated
     */
    public void setUrlName(String urlName) {
        this.urlName = urlName == null ? null : urlName.trim();
    }

    /**
     * 
     *  url类型,所属表字段为blog.url_type
     *
     * @return the value of blog.url_type
     */
    public String getUrlType() {
        return urlType;
    }

    /**
    blog.url_type
     *
     * @param urlType the value for blog.url_type
     *
     * @mbg.generated
     */
    public void setUrlType(String urlType) {
        this.urlType = urlType == null ? null : urlType.trim();
    }

    /**
     * 
     *  标签,所属表字段为blog.tags
     *
     * @return the value of blog.tags
     */
    public String getTags() {
        return tags;
    }

    /**
    blog.tags
     *
     * @param tags the value for blog.tags
     *
     * @mbg.generated
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * 
     *  是否删除 1 是 0 否,所属表字段为blog.is_deleted
     *
     * @return the value of blog.is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
    blog.is_deleted
     *
     * @param isDeleted the value for blog.is_deleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 
     *  是否置顶,所属表字段为blog.is_top
     *
     * @return the value of blog.is_top
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
    blog.is_top
     *
     * @param isTop the value for blog.is_top
     *
     * @mbg.generated
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    /**
     * 
     *  创建时间,所属表字段为blog.create_time
     *
     * @return the value of blog.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
    blog.create_time
     *
     * @param createTime the value for blog.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     *  创建人,所属表字段为blog.create_man
     *
     * @return the value of blog.create_man
     */
    public String getCreateMan() {
        return createMan;
    }

    /**
    blog.create_man
     *
     * @param createMan the value for blog.create_man
     *
     * @mbg.generated
     */
    public void setCreateMan(String createMan) {
        this.createMan = createMan == null ? null : createMan.trim();
    }

    /**
     * 
     *  修改时间,所属表字段为blog.update_time
     *
     * @return the value of blog.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
    blog.update_time
     *
     * @param updateTime the value for blog.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     *  修改人,所属表字段为blog.update_man
     *
     * @return the value of blog.update_man
     */
    public String getUpdateMan() {
        return updateMan;
    }

    /**
    blog.update_man
     *
     * @param updateMan the value for blog.update_man
     *
     * @mbg.generated
     */
    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan == null ? null : updateMan.trim();
    }

    /**
     * 
     *  版本,所属表字段为blog.version
     *
     * @return the value of blog.version
     */
    public Integer getVersion() {
        return version;
    }

    /**
    blog.version
     *
     * @param version the value for blog.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 
     *  浏览次数,所属表字段为blog.view
     *
     * @return the value of blog.view
     */
    public Integer getView() {
        return view;
    }

    /**
    blog.view
     *
     * @param view the value for blog.view
     *
     * @mbg.generated
     */
    public void setView(Integer view) {
        this.view = view;
    }

    /**
     * 
     *  发布状态,所属表字段为blog.status
     *
     * @return the value of blog.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
    blog.status
     *
     * @param status the value for blog.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     *  发布时间,所属表字段为blog.publish_time
     *
     * @return the value of blog.publish_time
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
    blog.publish_time
     *
     * @param publishTime the value for blog.publish_time
     *
     * @mbg.generated
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 
     *  内容,所属表字段为blog.content
     *
     * @return the value of blog.content
     */
    public String getContent() {
        return content;
    }

    /**
    blog.content
     *
     * @param content the value for blog.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}