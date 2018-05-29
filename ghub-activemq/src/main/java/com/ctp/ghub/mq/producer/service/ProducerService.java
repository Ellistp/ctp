package com.ctp.ghub.mq.producer.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
@Service
public class ProducerService {
    private static final Logger logger = Logger.getLogger(ProducerService.class);

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     *  向指定队列发送消息
     * @param destination
     * @param msg
     */
    public void sendMessage(Destination destination, final String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息=======;消息内容是：" + msg);
        logger.info("向队列" + destination.toString() + "发送了消息=======;消息内容是：" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 向默认队列发送消息
     * @param msg
     */
    public void sendMessage(final String msg) {
        String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列" +destination+ "发送了消息=======;消息内容是：" + msg);
        logger.info("向队列" + destination + "发送了消息=======;消息内容是：" + msg);
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
