package com.congfu.model.blog;

import com.congfu.common.BaseModel;

public class Tag extends BaseModel{
    /**
     * 标签名
     */
    private String name;
    /**
     *  使用次数
     */
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
