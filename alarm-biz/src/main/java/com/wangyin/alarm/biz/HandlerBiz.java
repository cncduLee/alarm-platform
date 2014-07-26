package com.wangyin.alarm.biz;

/**
 * Created by wylipengming on 2014/7/26.
 */
public interface HandlerBiz {
    public void handle();
    public boolean isRunning();
    public void setRunning(boolean running) ;
}
