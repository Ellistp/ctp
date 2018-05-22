package com.ctp.ghub.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@Aspect
@Component
public class LogAop {
    private static final Logger logger = Logger.getLogger(LogAop.class);

}
