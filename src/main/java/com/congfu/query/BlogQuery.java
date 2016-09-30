package com.congfu.query;

import java.util.Date;

public class BlogQuery {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 作者
     */
    private String  author;
    /**
     * 标题
     */
    private String  title;
    /**
     * 标题颜色
     */
    private String  color;
    /**
     * url名
     */
    private String  urlName;
    /**
     * url 访问形式
     */
    private String  urlType;
    /**
     * 内容
     */
    private String  content;
    /**
     * 标签
     */
    private String  tags;
    /**
     * 状态状态{0:正常,1:草稿,2:回收站}'
     * 
     */
    private String  status;
    /**
     * 发布时间
     */
    private Date    publishTimeBegin;
    private Date    publishTimeEnd;

    private Date    createTimeBegin;
    private Date    createTimeEnd;
    /**
     * 是否删除 1 true， 0 false
     */
    private Integer isDeleted;
    /**
     * 是否置顶 1 true， 0 false
     */
    private Integer isTop;

    private String  createMan;

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getPublishTimeBegin() {
        return publishTimeBegin;
    }

    public void setPublishTimeBegin(Date publishTimeBegin) {
        this.publishTimeBegin = publishTimeBegin;
    }

    public Date getPublishTimeEnd() {
        return publishTimeEnd;
    }

    public void setPublishTimeEnd(Date publishTimeEnd) {
        this.publishTimeEnd = publishTimeEnd;
    }

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

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }
}
