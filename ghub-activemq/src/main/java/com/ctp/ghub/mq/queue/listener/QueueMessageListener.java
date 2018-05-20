package com.ctp.ghub.mq.queue.listener;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
public class QueueMessageListener implements MessageListener {
    private static final Logger logger = Logger.getLogger(QueueMessageListener.class);

    //当收到消息后，自动调用该方法
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了消息;消息内容是：" + tm.getText());
            logger.info("QueueMessageListener监听到了消息;消息内容是：" + tm.getText());
            //TODO something ...
        } catch (JMSException e) {
            logger.error("activemq在监听消息时发生的异常: ",e);
        }
    }
}
