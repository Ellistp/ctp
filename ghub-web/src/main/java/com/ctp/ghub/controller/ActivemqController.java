package com.ctp.ghub.controller;

import com.ctp.ghub.mq.consumer.service.ProducerService;
import com.ctp.ghub.mq.producer.service.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
@Controller
public class ActivemqController {
    private static final Logger logger = Logger.getLogger(ActivemqController.class);

    //消息地址
    @Resource(name="ghubQueueDestination")
    private Destination ghubQueueDestination;

    //队列消息生产者
    @Resource(name="producerService")
    private ProducerService producer;

    //队列消息消费者
    @Resource(name="consumerService")
    private ConsumerService consumer;

    @RequestMapping(value="/sendMessage",method= RequestMethod.POST)
    public String producer(@RequestParam("message") String message) {
        logger.info("正在发送消息，消息内容是：" + message);
        producer.sendMessage(ghubQueueDestination, message);
        return message;
    }

    @RequestMapping(value="/receiveMessage",method=RequestMethod.GET)
    public String queue_receive() throws JMSException {
        TextMessage tm = consumer.receiveMessage(ghubQueueDestination);
        logger.info("已接收到消息，消息内容是：" + tm.getText());
        return tm.getText();
    }
}
