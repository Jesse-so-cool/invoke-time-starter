package com.jesse.invoketime.config;

import com.jesse.invoketime.annotation.Time;
import com.jesse.invoketime.interceptor.MethodInteceptor;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 省略 @EnableAspectJAutoProxy
@Configuration
public class AutoConfiguration extends AbstractPointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
        return new AnnotationMatchingPointcut(null, Time.class);
    }

    @Override
    public Advice getAdvice() {
        return new MethodInteceptor();
    }

}
