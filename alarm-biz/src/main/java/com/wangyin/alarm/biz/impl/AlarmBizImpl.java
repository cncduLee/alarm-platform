package com.wangyin.alarm.biz.impl;

import com.wangyin.alarm.biz.AlarmBiz;
import com.wangyin.alarm.biz.HandlerBiz;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wylipengming on 2014/7/26.
 */

@Service("alarmBiz")
public class AlarmBizImpl implements AlarmBiz {

    @Resource(name = "IMQ")
    private IMQ mq;

    @Resource(name = "handlerBiz")
    private HandlerBiz handlerBiz;

    @Override
    public void proccess(Message message) {
        //【此处省略】校验，转换
        mq.offer(message);

        if(!handlerBiz.isRunning()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //给消费端发送一个事件，让其开始处理
                    handlerBiz.setRunning(true);
                    handlerBiz.handle();
                }
            }).start();
        }
    }
}
