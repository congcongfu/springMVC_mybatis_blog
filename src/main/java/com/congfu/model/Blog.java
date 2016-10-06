package com.congfu.model;

import java.util.Date;

import org.springframework.cglib.beans.BulkBean;

import com.congfu.common.BaseModel;
import com.sun.tools.classfile.StackMapTable_attribute.append_frame;

public class Blog extends BaseModel {
  /**
   * 用户id
   */
  private Integer userId;
  
   /**
    * 作者
    */
  private String author;
  /**
   * 标题
   */
  private String title;
  /**
   * 标题颜色
   */
  private String color;
  /**
   * url名
   */
  private String urlName;
  /**
   * url 访问形式
   */
  private String urlType;
  /**
   * 内容
   */
  private String content;
  /**
   * 标签
   */
  private String tags;
  /**
   * 查看次数
   */
  private String view;
  /**
   * 状态状态{0:正常,1:草稿,2:回收站}'

   */
  private String status;
  /**
   * 发布时间
   */
  private Date publishTime;
  /**
   * 是否删除 1 true， 0 false
   */
  private Integer isDeleted;
  /**
   * 是否置顶 1 true， 0 false
   */
  private Integer isTop;
  
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
    public String geturlType() {
        return urlType;
    }
    public void seturlType(String urlType) {
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
    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Integer getIsTop() {
        return isTop;
    }
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
    @Override 
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(" userId :").append(userId)
                .append(" ,author :").append(author)
                .append(" ,title :").append(title)
                .append(" ,color :").append(color)
                .append(" ,urlName :").append(urlName)
                .append(" ,urlType :").append(urlType)
                .append(" ,content :").append(content)
                .append(" ,tags :").append(tags)
                .append(" ,view :").append(view)
                .append(" ,status :").append(status)
                .append(" ,publishTime :").append(publishTime)
                .append(" ,isDeleted :").append(isDeleted)
                .append(" ,isTop :").append(isTop);
        builder.append("}");
        return builder.toString();
    }
}
