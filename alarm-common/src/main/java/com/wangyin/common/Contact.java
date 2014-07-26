package com.wangyin.common;

import java.io.Serializable;

/**
 * Created by wylipengming on 2014/7/25.
 * 联系人信息
 */
public class Contact implements Serializable{
    private String calling;

    public Contact(String calling) {
        this.calling = calling;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }
}
