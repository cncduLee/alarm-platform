package com.wangyin.biz;

import com.wangyin.BaseTestCase;
import com.wangyin.alarm.biz.HandlerBiz;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HandlerBizTest extends BaseTestCase{

    @Resource(name = "handlerBiz")
    private HandlerBiz handlerBiz;

    @Resource(name = "IMQ")
    private IMQ<Message> mq;

    @Test
    public void testHandle() throws Exception {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("123"));
        contacts.add(new Contact("234"));

        Message message = new Message();
        message.setCalls(contacts);
        message.setContent("test");

        mq.offer(message);

        handlerBiz.setRunning(true);
        handlerBiz.handle();
    }
}