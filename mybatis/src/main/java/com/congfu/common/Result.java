package com.congfu.common;

public class Result<T> {
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;
    
    /**
     * 状态
     */
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
