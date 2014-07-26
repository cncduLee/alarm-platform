package com.wangyin.mq;

import com.wangyin.common.Message;
import com.wangyin.common.code.MessageType;
import com.wangyin.mq.impl.IMQImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMQImplTest {

    IMQ<Message> mq;


    @Before
    public void setUp() throws Exception {
        mq = IMQImpl.getInstance();
    }

    @Test
    public void testOffer() throws Exception {
        Message message1 = new Message();
        Message message2 = new Message();

        message1.setMessageType(MessageType.EMAIL);
        message2.setMessageType(MessageType.SMS);

        message1.setContent("---");
        message1.setContent("--||--");

        mq.offer(message1);
        mq.offer(message2);
    }

    @Test
    public void testPoll() throws Exception {
        Message message1 = new Message();
        Message message2 = new Message();
        Message message3 = new Message();


        message1.setMessageType(MessageType.EMAIL);
        message2.setMessageType(MessageType.SMS);
        message3.setMessageType(MessageType.SMS);


        message1.setContent("---");
        message2.setContent("--||--");
        message3.setContent("--%%%%--");

        mq.offer(message1);
        mq.offer(message2);
        mq.offer(message3);

        Message r1 = mq.poll();
        Message r2 = mq.poll();
        Message r3 = mq.poll();

        Assert.assertEquals(MessageType.EMAIL, r3.getMessageType());
        Assert.assertEquals(MessageType.SMS, r2.getMessageType());
        Assert.assertEquals(MessageType.SMS,r1.getMessageType());
    }
}