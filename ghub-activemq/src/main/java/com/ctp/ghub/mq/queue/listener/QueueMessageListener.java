package com.ctp.ghub.mq.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.alibaba.fastjson.JSON;
import com.ctp.ghub.model.smsmessage.SmsMessageDTO;
import com.ctp.ghub.mq.sms.sender.SmsMessageSender;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
public class QueueMessageListener implements MessageListener {

    private static final Logger logger = Logger.getLogger(QueueMessageListener.class);

    @Autowired
    private SmsMessageSender smsMessageSender;

    /**
     * 当监听器监听到消息后，自动调用该方法
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String jsonStr = textMessage.getText();
            System.out.println("QueueMessageListener监听到了消息;消息内容是：" + jsonStr);
            logger.info("QueueMessageListener监听到了消息;消息内容是：" + jsonStr);
            if (StringUtils.isNotBlank(jsonStr)) {
                SmsMessageDTO messageDTO = JSON.parseObject(jsonStr, SmsMessageDTO.class);
                smsMessageSender.send(messageDTO);
            }
        } catch (JMSException e) {
            logger.error("activemq在监听消息时发生的异常: ",e);
        }
    }
}
