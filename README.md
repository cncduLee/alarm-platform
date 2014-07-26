#开发说明

##项目结构
	
	alarm-platform/
		* biz           业务逻辑层
		* common        通用的基础实体
		* emit 		    发射器
		* facade  		对外接口
		* monitor  		监控 
		* mq            自定义的消息中间件
		* standalone    发布配置
		* third         依赖接入【解决耦合】
		* test          测试
		
## 依赖包
    
    Spring-core
    Spring-bean
    Spring-context
    Spring-test
    junit
    
##扩展说明

###如:添加微信发送方式：
    1：对外部以来的扩展方式进行适配,做法是:在emit(发送器)部分添加适配WxSender.java
        public class WxSender extends BaseSender{
            public WxSender() {
                super();
            }
        
            @Override
            protected void thirdSend(String content, String calling) {
                WxUtils.getInstance().sendMessage(content, calling);
            }
        }
    2: 定义优先级规则：在rule.properties加入
       WX=2 
    3：添加enum，定义发送选项
       WX(1,"微信","wx"),//微信
       
##设计思路
   
   ![DataV logo](https://raw.github.com/cncduLee/alarm-platform/master/work.png)    

##说明
    
    1：由于时间仓促，还没怎么测试，所以测试覆盖率不高。这个写的太累赘了，应该在明天会放一个小巧的版本
    2：推荐看我以前写的这个p-c代码(有rpc的东西在里面)：https://github.com/cncduLee/asynchronous/
     