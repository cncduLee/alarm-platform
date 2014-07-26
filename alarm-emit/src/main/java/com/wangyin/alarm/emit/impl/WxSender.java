package com.wangyin.alarm.emit.impl;

import com.wangyin.alarm.third.WxUtils;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class WxSender extends BaseSender{
    public WxSender() {
        super();
    }

    @Override
    protected void thirdSend(String content, String calling) {
        WxUtils.getInstance().sendMessage(content, calling);
    }
}
