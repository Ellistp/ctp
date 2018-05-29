package com.ctp.ghub.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.ctp.ghub.model.smsmessage.SmsMessageDTO;
import com.ctp.ghub.mq.producer.service.ProducerService;
import com.ctp.ghub.service.SmsMessageService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
@Service("smsMessageService")
public class SmsMessageServiceImpl implements SmsMessageService {

    private static final Logger logger = Logger.getLogger(SmsMessageServiceImpl.class);

    protected final ExecutorService sendSmsExecutor = Executors.newFixedThreadPool(100);

    /**
     * 消息地址
     */
    @Resource(name="ghubQueueDestination")
    private Destination ghubQueueDestination;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private ProducerService producerService;

    @Override
    public String generateVerifyCode(String smsMessageType, String mobile, int length) {
        String verifyCode = (String) redisTemplate.opsForValue().get(smsMessageType + mobile);

        if (StringUtils.isBlank(verifyCode)) {
            //TODO
            verifyCode = "123456";
        }
        redisTemplate.opsForValue().set(smsMessageType + mobile, verifyCode, 60, TimeUnit.SECONDS);
        return verifyCode;
    }

    @Override
    public void send(String smsMessageType, String mobile, String content) {
        sendSmsExecutor.execute(() -> {
            if (StringUtils.isBlank(mobile)) {
                logger.error("手机号码不能为空！");
                return;
            }
            SmsMessageDTO smsMessageDTO = new SmsMessageDTO();
            smsMessageDTO.setMobile(mobile);
            smsMessageDTO.setSmsMessageType(smsMessageType);
            smsMessageDTO.setContent(content);
            producerService.sendMessage(ghubQueueDestination, JSON.toJSONString(smsMessageDTO));
        });
    }
}
