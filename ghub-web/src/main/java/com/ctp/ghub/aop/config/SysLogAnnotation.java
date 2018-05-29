package com.ctp.ghub.aop.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chengtianping
 * @description 系统日志注解
 * @date 2018/5/29
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogAnnotation {

    String moduleName()  default "";
    String operateType()  default "";
    String operateDesc() default "";
}
