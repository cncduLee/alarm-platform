package com.wangyin.common;

import java.io.Serializable;

/**
 * Created by wylipengming on 2014/7/24.
 */
public class Param<T> implements Serializable{
    private String logParam;//日志【注：可以是类型】
    private T      data;//参数

    public Param() {
    }

    public Param(String logParam) {
        this.logParam = logParam;
    }

    public Param(T data) {
        this.data = data;
    }

    public Param(String logParam, T data) {
        this.logParam = logParam;
        this.data = data;
    }

    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logParam) {
        this.logParam = logParam;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
