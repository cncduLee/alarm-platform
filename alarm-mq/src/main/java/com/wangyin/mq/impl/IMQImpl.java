package com.wangyin.mq.impl;

import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;
import com.wangyin.mq.code.MyRuler;
import com.wangyin.mq.code.Ruler;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by wylipengming on 2014/7/26.
 */
@Component("IMQ")
public class IMQImpl implements IMQ<Message>,Serializable {

    private static PriorityBlockingQueue<Message> que;

    private static class SiglentonHolder{
        private final static IMQImpl singleton = new IMQImpl();
    }

    public static IMQImpl getInstance(){
        return SiglentonHolder.singleton;
    }

    private IMQImpl() {
        this(Integer.MAX_VALUE/1024);
    }

    private IMQImpl(int initialCapacity) {
        this(initialCapacity,new MyRuler<Message>());
    }

    private IMQImpl(int initialCapacity,Ruler<Message> ruler){
        this.que = new PriorityBlockingQueue<Message>(initialCapacity,ruler);
    }



    @Override
    public Boolean offer(Message param) {
        return que.offer(param);
    }

    @Override
    public Message poll() {
        return que.poll();
    }

    @Override
    public Message peek() {
        return que.peek();
    }

    @Override
    public Boolean isEmpty() {
        return que.isEmpty();
    }
}
