package com.wangyin.alarm.emit;

import com.wangyin.common.Message;

/**
 * Created by wylipengming on 2014/7/26.
 */
public interface Sender extends Runnable {
    public void send(String content,String calling);
    public void setData(Message message);
}
