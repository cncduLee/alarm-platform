package com.wangyin.common.code;

/**
 * Created by wylipengming on 2014/7/25.
 */
public enum MessageType {
    SMS(1,"短信","sms"),//短信
    EMAIL(1,"邮箱","email"),//邮箱
    WX(1,"微信","wx"),//微信
    OTHERS(1,"其他","other")//其他
    ;

    private Integer code;
    private String  desc;
    private String  msg;

    MessageType(Integer code, String msg, String desc) {
        this.code = code;
        this.desc = desc;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
