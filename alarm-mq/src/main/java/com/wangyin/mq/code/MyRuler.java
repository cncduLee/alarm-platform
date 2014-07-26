package com.wangyin.mq.code;

import com.wangyin.common.Message;
import com.wangyin.common.code.MessageType;
import com.wangyin.common.utils.PropertyUtil;

import java.util.Map;

/**
 * Created by wylipengming on 2014/7/26.
 * 越小优先级越高
 */
public class MyRuler<M> implements Ruler<M>{
    private static Map<MessageType,Object> ruler = PropertyUtil.ruleMap();

    @Override
    public int compare(M o1, M o2) {
        int val1 = Integer.parseInt( ruler.get(((Message)o1).getMessageType()).toString() );
        int val2 = Integer.parseInt( ruler.get(((Message)o2).getMessageType()).toString() );
        return val1 < val2 ? -1 : 1;
    }

}
