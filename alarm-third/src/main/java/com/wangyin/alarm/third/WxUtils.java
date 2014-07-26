package com.wangyin.alarm.third;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class WxUtils {
    private WxUtils(){}
    private static WxUtils instance;


    public static WxUtils getInstance(){
        if(instance == null){
            instance = new WxUtils();
        }
        return instance;
    }

    public void sendMessage(String content,String calling){
        System.out.println(Thread.currentThread().getName() +":::【微信：："+System.currentTimeMillis()+"】  calling:"+calling+">>>>"+content);
    }
}
