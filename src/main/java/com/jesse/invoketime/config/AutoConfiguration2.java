package com.jesse.invoketime.config;

import com.jesse.invoketime.annotation.Time;
import com.jesse.invoketime.aspects.TimeAspect;
import com.jesse.invoketime.interceptor.MethodInteceptor;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 仅使用一个aspect注解的情况下就可以实现
 *
 * 必须使用@Import spring boot默认只扫描启动器类的同包或者其子包的下的
 */
@Configuration
@Import(TimeAspect.class)
public class AutoConfiguration2  {

}
