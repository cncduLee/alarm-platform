package com.wangyin.mq.impl;


import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;

import java.io.Serializable;

/**
 * Created by wylipengming on 2014/7/26.
 * ActivMQ实现
 */
public class IMQActiveMQImpl implements IMQ<Message>, Serializable{

    @Override
    public Boolean offer(Message param) {
        return null;
    }

    @Override
    public Message poll() {
        return null;
    }

    @Override
    public Message peek() {
        return null;
    }

    @Override
    public Boolean isEmpty() {
        return null;
    }
}