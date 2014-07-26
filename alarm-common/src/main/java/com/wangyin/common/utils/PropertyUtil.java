package com.wangyin.common.utils;

import com.wangyin.common.Constants;
import com.wangyin.common.code.MessageType;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class PropertyUtil {
    private static Properties p;
    private static String configPath = Constants.DEFAULT_CONFIG;
    private static String ruleConfigPath = Constants.RULE_CONFIG;


    private PropertyUtil(){}

    public static PropertyUtil getInstall(){
        return SingletonHolder.singleton;
    }

    public static Map<MessageType,Object> ruleMap(){
        Map<MessageType,Object> map = new HashMap<MessageType, Object>();
        for(MessageType mt : MessageType.values()){
            Object obj = getInstall().readProperty(ruleConfigPath, mt.getDesc().toUpperCase());
            if(obj != null){
                map.put(mt,obj);
            }
        }
        return map;
    }

    /**
     * 读取键值数据
     * @param key
     * @return
     */
    public Object readProperty(String configPath,String key){
        return getProperty(configPath).get(key);
    }

    /**
     * 【编码转换】  读取键值数据
     * @param configPath
     * @param key
     * @return
     */
    public String readPropertyWithByte(String configPath,String key,String encode,String decode){
        String pro = getProperty(configPath).getProperty(key);
        try {
            return new String(pro.getBytes(encode), decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static class SingletonHolder{
        public static PropertyUtil singleton = new PropertyUtil();
    }

    private Properties getProperty(){
        if(p == null){
            p = new Properties();
        }
        return p;
    }


    private Properties getProperty(String configPath){
        //如果不是当前路径。则强制修改配置文件路径
        if(!PropertyUtil.configPath.equals(configPath)){
            PropertyUtil.configPath = configPath;
            p = null;
        }

        if(null == configPath || "".equals(configPath)){
            System.out.println("配置文件路径不存在或者非法");
            return null;
        }

        if(p == null){
            p = getProperty();
            InputStream i = getInstall().getClass().getClassLoader().getResourceAsStream(configPath);
            try {
                p.load(i);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("配置文件路径不正确" + e.getMessage());
            }
        }
        return p;
    }
}
