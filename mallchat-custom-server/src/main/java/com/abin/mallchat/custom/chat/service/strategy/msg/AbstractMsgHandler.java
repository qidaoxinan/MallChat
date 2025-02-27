package com.abin.mallchat.custom.chat.service.strategy.msg;

import com.abin.mallchat.common.chat.domain.entity.Message;
import com.abin.mallchat.common.chat.domain.enums.MessageTypeEnum;
import com.abin.mallchat.custom.chat.domain.vo.request.ChatMessageReq;

import javax.annotation.PostConstruct;

/**
 * Description: 消息处理器抽象类
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-06-04
 */
public abstract class AbstractMsgHandler {

    /**
     * 继承类，当Bean被创建并且它的依赖项被注入后，容器会自动调用
     * getMsgTypeEnum 获取继承类配置的参数
     */
    @PostConstruct
    private void init() {
        MsgHandlerFactory.register(getMsgTypeEnum().getType(), this);
    }

    abstract MessageTypeEnum getMsgTypeEnum();

    public abstract void checkMsg(ChatMessageReq req, Long uid);

    public abstract void saveMsg(Message msg, ChatMessageReq req);

    public abstract Object showMsg(Message msg);

    public abstract Object showReplyMsg(Message msg);

}
