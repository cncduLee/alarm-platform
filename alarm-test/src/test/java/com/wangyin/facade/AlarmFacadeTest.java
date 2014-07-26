package com.wangyin.facade;

import com.wangyin.BaseTestCase;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.common.Param;
import com.wangyin.common.Result;
import com.wangyin.common.code.CommonEnum;
import com.wangyin.common.code.MessageType;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class AlarmFacadeTest extends BaseTestCase{

    @Resource(name="alarmFacade")
    private AlarmFacade alarmFacade;

    @Test
    public void testProccess() throws Exception {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("123"));
        contacts.add(new Contact("234"));

        Message message = new Message();
        message.setCalls(contacts);
        message.setContent("test");

        for(int a = 0;a<100;a++){
            if(a % 2 == 0){
                message.setMessageType(MessageType.SMS);
            }else if(a % 2 == 1){
                message.setMessageType(MessageType.EMAIL);
            }
            Param<Message> param = new Param<Message>(message);
            Result result = alarmFacade.proccess(param);
//            Assert.assertNotNull(result);
//            Assert.assertEquals(CommonEnum.SUCCESS, result.getCode());
        }


    }
}