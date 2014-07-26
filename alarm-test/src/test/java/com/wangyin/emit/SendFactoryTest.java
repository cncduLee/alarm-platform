package com.wangyin.emit;

import com.wangyin.BaseTestCase;
import com.wangyin.alarm.emit.SendFactory;
import com.wangyin.alarm.emit.Sender;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.common.code.MessageType;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SendFactoryTest extends BaseTestCase{

    @Resource(name="sendFactory")
    private SendFactory sf;

    @Test
    public void testSend() throws Exception {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("123"));
        contacts.add(new Contact("234"));

        Message message = new Message();
        message.setCalls(contacts);
        message.setContent("test");
        message.setMessageType(MessageType.SMS);

        Sender sender = sf.send(message);
        Assert.assertNotNull(sender);
    }
}