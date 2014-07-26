package com.wangyin.facade.impl;

import com.wangyin.alarm.biz.AlarmBiz;
import com.wangyin.common.Contact;
import com.wangyin.common.Message;
import com.wangyin.common.Param;
import com.wangyin.common.Result;
import com.wangyin.common.code.CommonEnum;
import com.wangyin.facade.AlarmFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/26.
 */

@Service("alarmFacade")
public class AlarmFacadeImpl implements AlarmFacade{

    @Resource(name="alarmBiz")
    private AlarmBiz alarmBiz;

    @Override
    public Result proccess(Param<Message> param) {
        //参数校验
        if (param == null || param.getData() == null){
            return new Result(CommonEnum.INVALI_PARAM);
        }
        //此处省略，日志参数校验
        try{
            alarmBiz.proccess(param.getData());
        }catch (Exception e){
            e.printStackTrace();
            //日志打印异常栈
            return new Result(CommonEnum.EXCEPTION);
        }
        return new Result(CommonEnum.SUCCESS);
    }
}
