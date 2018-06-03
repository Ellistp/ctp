package com.ctp.ghub.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.ctp.ghub.aop.config.SysLogAnnotation;
import com.ctp.ghub.enums.log.OperateStatusEnum;
import com.ctp.ghub.model.LogDO;
import com.ctp.ghub.service.LogService;
import com.ctp.ghub.utils.HttpUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/22
 */
@Aspect
public class ControllerAop {
    private static final Logger logger = Logger.getLogger(ControllerAop.class);

    @Autowired
    private LogService logService;

    private LogDO logDO = new LogDO();

    /**
     * 定义所有的 controller 切入点
     * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
     */
//    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    @Pointcut("execution(public * com.ctp.ghub.controller.*.*(..))")
    public void controller() {
    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     * @param joinPoint
     * @throws Throwable
     */
    @Before("controller() && args(..,request)")
    public void controllerAopBefore(JoinPoint joinPoint,HttpServletRequest request) throws Throwable {
        if (null != request) {
            if(logger.isInfoEnabled()){
                logger.info("controller aop before " + joinPoint);
            }
        }
    }

    /**
     * 配置后置通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
    @AfterReturning(pointcut = "controller()")
    public void controllerAopAfterReturn(JoinPoint joinPoint) {
        if(logger.isInfoEnabled()){
            logger.info("controller aop after " + joinPoint);
        }
        this.logService.insert(logDO);
    }

    /**
     * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = "controller()", throwing = "exception")
    public void controllerAopAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("controllerAopAfterThrowing " + exception);
        logDO.setOperateStatus(OperateStatusEnum.FAILURE.getCode());
        this.logService.insert(logDO);
    }

    /**
     * 配置环绕通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("controller()")
    public Object controllerAopAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 拦截的实体类，就是当前正在执行的controller
        Object target = joinPoint.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = joinPoint.getSignature().getName();
        // 拦截的方法参数
        Object[] args = joinPoint.getArgs();
        // 拦截的放参数类型
        Signature sig = joinPoint.getSignature();

        logDO.setIp(HttpUtil.getRealIpAddress(request));
        logDO.setUrl(request.getRequestURI());
        MethodSignature msig;
        if (!(sig instanceof MethodSignature)) {
            logger.error("该注解只能用于方法");
            return joinPoint.proceed();
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            logger.error("controllerAopAround NoSuchMethodException :  ",e);
        } catch (SecurityException e) {
            logger.error("controllerAopAround SecurityException :  ",e);
        }

        if (null != method) {
            // 判断是否需要使用自定义日志注解
            if (method.isAnnotationPresent(SysLogAnnotation.class)) {
                SysLogAnnotation sysLogAnnotation = method.getAnnotation(SysLogAnnotation.class);
                logDO.setOperateType(sysLogAnnotation.operateType());
                logDO.setOperateDesc(sysLogAnnotation.operateDesc());
                logDO.setModuleName(sysLogAnnotation.moduleName());
                logDO.setOperateStatus(OperateStatusEnum.SUCCESS.getCode());
            }else {
                logDO.setOperateDesc("当前操作不需要注解");
            }
        }else {
            //不需要拦截直接放行
            logDO.setOperateDesc("不需要拦截直接放行");
        }
        logger.info("controllerAopAround " + joinPoint);
        return joinPoint.proceed();
    }
}
