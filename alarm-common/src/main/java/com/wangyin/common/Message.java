package com.wangyin.common;

import com.wangyin.common.code.MessageType;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/24.
 * 报警信息
 */
public class Message implements Serializable{
    private MessageType   messageType;//报警类型
    private String        content;    //报警内容
    private List<Contact> calls;      //名单
    private String        sender;     //发送者
    private Date          sendTime;   //发送时间
    private Integer       retryTime;  //重试次数

    public Message() {
        this.messageType = MessageType.SMS;
        this.sendTime = new Date();
        this.retryTime = Constants.RETRY_TIME;
    }

    public Message(MessageType messageType, String content, List<Contact> calls, String sender) {
        this.messageType = messageType;
        this.content = content;
        this.calls = calls;
        this.sender = sender;
        this.sendTime = new Date();
        this.retryTime = Constants.RETRY_TIME;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Contact> getCalls() {
        return calls;
    }

    public void setCalls(List<Contact> calls) {
        this.calls = calls;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
    }
}
