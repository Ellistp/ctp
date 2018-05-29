package com.ctp.ghub.controller;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import com.ctp.ghub.enums.sms.SmsMessageEnum;
import com.ctp.ghub.model.Result;
import com.ctp.ghub.model.MessageEntity;
import com.ctp.ghub.mq.consumer.service.ConsumerService;
import com.ctp.ghub.service.SmsMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
@Controller
@RequestMapping("/api/ghub/mq")
public class ActivemqController {
    private static final Logger logger = Logger.getLogger(ActivemqController.class);

    /**
     * 消息地址
     */
    @Resource(name="ghubQueueDestination")
    private Destination ghubQueueDestination;

    @Autowired
    private SmsMessageService smsMessageService;

    /**
     * 消息队列消费者
     */
    @Resource(name="consumerService")
    private ConsumerService consumer;

    @RequestMapping(value="/sendMessage",method= RequestMethod.POST)
    @ResponseBody
    public Result<String> sendMessage(@RequestBody MessageEntity messageEntity) {
        logger.info("正在发送消息，消息内容是：" + messageEntity.getPhone());
        String verifyCode = smsMessageService.generateVerifyCode(SmsMessageEnum.REGISTER_VERIFY_CODE.getCode(), messageEntity.getPhone(), 6);
        smsMessageService.send(SmsMessageEnum.REGISTER_VERIFY_CODE.getCode(),messageEntity.getPhone(),verifyCode);
        return Result.createSuccessResult(verifyCode);
    }

    @RequestMapping(value="/receiveMessage",method=RequestMethod.GET)
    @ResponseBody
    public Result<String> receiveMessage() throws JMSException {
        TextMessage tm = consumer.receiveMessage(ghubQueueDestination);
        logger.info("已接收到消息，消息内容是：" + tm.getText());
        return Result.createSuccessResult(tm.getText());
    }
}
