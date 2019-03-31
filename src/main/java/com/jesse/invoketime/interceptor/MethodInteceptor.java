package com.jesse.invoketime.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * 采用实现MethodInterceptor的方式实现around
 */
public class MethodInteceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        final Object proceed = invocation.proceed();
        System.out.println("方法 "+invocation.getMethod().getName()+"执行时间为:"+(System.currentTimeMillis()-start)+"ms");
        return proceed;
    }
}
