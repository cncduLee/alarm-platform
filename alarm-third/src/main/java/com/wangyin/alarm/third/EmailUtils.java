package com.wangyin.alarm.third;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class EmailUtils {
    private EmailUtils() {
    }

    private static class SingletonHolder{
        private final static EmailUtils singleton = new EmailUtils();
    }

    public static EmailUtils getInstance(){
        return SingletonHolder.singleton;
    }

    public void sendMessage(String content,String calling){
        System.out.println(Thread.currentThread().getName() +":::【邮件：："+System.currentTimeMillis()+"】  calling:"+calling+">>>>"+content);
    }
}
