package com.wangyin.alarm.emit.impl;

import com.wangyin.alarm.emit.Sender;
import com.wangyin.alarm.third.EmailUtils;
import com.wangyin.alarm.third.SmsUtils;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/26.
 */

@Component("smsSender")
public class SmsSender extends BaseSender{
    public SmsSender() {
        super();
    }

    @Override
    protected void thirdSend(String content, String calling) {
        SmsUtils.getInstance().sendMessage(content, calling);
    }
}
