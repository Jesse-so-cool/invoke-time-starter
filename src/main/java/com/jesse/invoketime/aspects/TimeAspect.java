package com.jesse.invoketime.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {

    @Pointcut("@annotation(com.jesse.invoketime.annotation.Time)")
    public void point() {
    }

//    @Before("point()")
//    public void logStart(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + "方法运行开始 参数为{" + Arrays.asList(joinPoint.getArgs()) + "}");
//    }
//
//    @After("point()")
//    public void logEnd(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + "方法运行结束 参数为{" + Arrays.asList(joinPoint.getArgs()) + "}");
//    }

    @AfterReturning(value = "point()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature() + "方法运行返回 返回值为{" + result.toString() + "}");
    }

    @AfterThrowing(value = "point()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        System.out.println(joinPoint.getSignature() + "方法运行异常 异常为{" + e + "}");
    }

    @Around(value = "point()")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("----------------------------------AOP--------------------------------------------------");
        long start = System.currentTimeMillis();
        Object proceed = jp.proceed();
        System.out.println("------------方法 "+jp.getSignature()+"执行 花费 :  "+(System.currentTimeMillis()-start)+"ms----------------");
        System.out.println("---------------------------------------------------------------------------------------");
        return proceed;
    }

}
