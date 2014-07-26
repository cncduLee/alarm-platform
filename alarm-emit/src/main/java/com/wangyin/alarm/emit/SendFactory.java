package com.wangyin.alarm.emit;

import com.wangyin.common.Message;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by wylipengming on 2014/7/26.
 */

@Component("sendFactory")
public class SendFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Sender send(Message message){
        if(message == null || message.getMessageType() == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append(message.getMessageType().getDesc().toLowerCase());
        sb.append("Sender");

        Sender sender = (Sender) applicationContext.getBean(sb.toString());
        sender.setData(message);
        return sender;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
