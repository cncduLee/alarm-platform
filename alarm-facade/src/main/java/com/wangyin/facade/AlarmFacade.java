package com.wangyin.facade;

import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.common.Param;
import com.wangyin.common.Result;

import java.util.List;

/**
 * Created by wylipengming on 2014/7/25.
 */
public interface AlarmFacade {
    /**
     * 报警处理
     * @param message 报警消息
     * @return        报警处理失败【消息为送达】的名单
     */
    public Result proccess(Param<Message> message);
}
