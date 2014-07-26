package com.wangyin.common;

import com.wangyin.common.code.CommonEnum;

import java.io.Serializable;

/**
 * Created by wylipengming on 2014/7/24.
 */
public class Result<T> implements Serializable {
    private CommonEnum code;
    private T          data;

    public Result() {
        this.code = CommonEnum.FAILE;
    }

    public Result(CommonEnum code) {
        this.code = code;
    }

    public Result(T data) {
        this.code = CommonEnum.SUCCESS;
        this.data = data;
    }

    public Result(CommonEnum code, T data) {
        this.code = code;
        this.data = data;
    }

    public CommonEnum getCode() {
        return code;
    }

    public void setCode(CommonEnum code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
