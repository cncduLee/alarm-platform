package com.wangyin.alarm.third;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class SmsUtils {
    private SmsUtils(){}
    private static SmsUtils instance;


    public static SmsUtils getInstance(){
        if(instance == null){
            instance = new SmsUtils();
        }
        return instance;
    }

    public void sendMessage(String content,String calling){
        System.out.println(Thread.currentThread().getName() +":::【短信：："+System.currentTimeMillis()+"】  calling:"+calling+">>>>"+content);
    }
}
