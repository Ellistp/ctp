package com.ctp.ghub.mq.sms.sender;

import com.ctp.ghub.model.smsmessage.SmsMessageDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
@Service("smsMessageSender")
public class SmsMessageSender {

    private static final Logger logger = Logger.getLogger(SmsMessageSender.class);

    /**
     * 发送短信服务
     * @param messageDTO
     */
    public void send(SmsMessageDTO messageDTO) {
        logger.info("开始发送短信： 发送的手机号是： " + messageDTO.getMobile() + " ====== 发送的内容是：  " + messageDTO.getContent());
    }
}
