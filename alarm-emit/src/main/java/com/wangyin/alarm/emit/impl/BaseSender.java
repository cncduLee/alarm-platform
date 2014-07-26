package com.wangyin.alarm.emit.impl;

import com.wangyin.alarm.emit.Sender;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/26.
 */
public abstract class BaseSender implements Sender,Serializable {
    protected Message message ;
//    @Resource(name="IMQ")
//    private IMQ<Message> mq;

    protected BaseSender() {
    }

    @Override
    public void send(String content, String calling) {
        thirdSend(content,calling);
    }

    @Override
    public void setData(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        if(message == null) return;
        List<Contact> fails = new ArrayList<Contact>();

        for (Contact contact : message.getCalls()) {
            try {
                send(message.getContent(),contact.getCalling());
            }catch (Exception e){
                fails.add(contact);
                System.out.print("send error::"+e.getMessage());
            }
        }

        //下面的逻辑：如果处理失败，就将失败的数据存到队列，后面二次处理
//        if(!fails.isEmpty()) {
//            message.setRetryTime(message.getRetryTime()-1);
//            message.setCalls(fails);
//            mq.offer(message);
//        }
    }

    protected abstract void thirdSend(String content, String calling) ;

}
