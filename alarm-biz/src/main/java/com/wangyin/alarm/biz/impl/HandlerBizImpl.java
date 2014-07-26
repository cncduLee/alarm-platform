package com.wangyin.alarm.biz.impl;

import com.wangyin.alarm.biz.HandlerBiz;
import com.wangyin.alarm.emit.SendFactory;
import com.wangyin.alarm.emit.impl.SmsSender;
import com.wangyin.common.Message;
import com.wangyin.common.utils.Threads;
import com.wangyin.mq.IMQ;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wylipengming on 2014/7/26.
 */

@Component("handlerBiz")
public class HandlerBizImpl implements HandlerBiz {

    @Resource(name="IMQ")
    private IMQ<Message> mq;

    @Resource(name="sendFactory")
    private SendFactory sf;

    private final static ExecutorService pool = Executors.newCachedThreadPool();
    private boolean running = false;
    private Long idle = 1 * 1000L;//懒停时间间隔

    @Override
    public void handle() {
        while (running) {
            Message message = mq.poll();
            if(message == null){
                Threads.sleep(idle);
            }else{
                pool.execute(sf.send(message));
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
