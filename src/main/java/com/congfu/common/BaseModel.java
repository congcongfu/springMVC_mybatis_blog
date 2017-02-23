package com.congfu.common;

import java.util.Date;

public class BaseModel {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date    createTime;
    /**
     * 更新时间
     */
    private Date    updateTime;
    /**
     * 创建人
     */
    private String  createMan;
    /**
     * 更新人
     */
    private String  updateMan;
    /**
     * 版本
     */
    private Long  version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getUpdateMan() {
        return updateMan;
    }

    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
