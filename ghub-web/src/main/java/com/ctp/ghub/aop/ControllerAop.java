package com.ctp.ghub.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@Aspect
public class ControllerAop {
    private static final Logger logger = Logger.getLogger(ControllerAop.class);

    /**
     * 定义所有的 controller 切入点
     * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
     */
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     * @param joinPoint
     * @param request
     * @throws Throwable
     */
    @Before("controller() && args(..,request)")
    public void controllerAopBefore(JoinPoint joinPoint, HttpServletRequest request) throws Throwable {
        if (null != request) {
            if(logger.isInfoEnabled()){
                logger.info("controller aop before " + joinPoint);
            }
        }
    }

    /**
     * 配置后置通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "controller()", returning = "result")
    public void controllerAopAfterReturn(JoinPoint joinPoint, Object result) {
        if(logger.isInfoEnabled()){
            logger.info("controller aop after " + joinPoint);
        }
    }

    /**
     * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = "controller()", throwing = "exception")
    public void controllerAopAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("controllerAopAfterThrowing " + exception);
    }

    /**
     * 配置环绕通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("controller()")
    public Object controllerAopAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        HttpServletResponse response = servletRequestAttributes.getResponse();
        logger.error("controllerAopAround " + joinPoint);
        return joinPoint.proceed();
    }
}
