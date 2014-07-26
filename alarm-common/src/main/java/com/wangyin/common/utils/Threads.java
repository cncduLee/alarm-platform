package com.wangyin.common.utils;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class Threads {
    public static void sleep(Long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
