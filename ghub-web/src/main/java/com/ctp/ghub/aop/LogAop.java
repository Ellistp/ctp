package com.ctp.ghub.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctp.ghub.model.LogDO;
import com.ctp.ghub.service.LogService;
import com.ctp.ghub.utils.HttpUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@Aspect
@Component
public class LogAop {
    private static final Logger logger = Logger.getLogger(LogAop.class);

    @Autowired
    LogService logService;

    /**
     * 定义所有的 controller 切入点
     * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
     */
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    /**
     * 定义所有的 方法的切入点
     * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
     */
    @Pointcut("execution(* *.*(..))")
    protected void allMethod() {
    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     * @param joinPoint
     * @param request
     * @throws Throwable
     */
    @Before("controller() && allMethod() && args(..,request)")
    public void logAopBefore(JoinPoint joinPoint, HttpServletRequest request) throws Throwable {
        if (null != request) {
            if(logger.isInfoEnabled()){
                logger.info("log aop before " + joinPoint);
            }
        }
    }

    /**
     * 配置后置通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "controller() && allMethod()", returning = "result")
    public void afterControllerMethod(JoinPoint joinPoint, Object result) {
        if(logger.isInfoEnabled()){
            logger.info("log aop after " + joinPoint);
        }
    }

    /**
     * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = "controller() && allMethod()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {

    }

    /**
     * 配置环绕通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("controller() && allMethod()")
    public Object logAopAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        LogDO logDO = new LogDO();
        logDO.setIp(HttpUtil.getIpAddress(request));
        logDO.setModuleName("account");
        logDO.setOperateDesc("测试");
        logDO.setOperateStatus(1);
        logDO.setOperateType("add");
        logDO.setUserId(1001L);
        logDO.setUrl(request.getRequestURI());
        logService.insert(logDO);
        return joinPoint.proceed();
    }

}
