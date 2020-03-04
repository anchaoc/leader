package com.ac.leader.aop;

import com.ac.leader.annotation.LogPrint;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 日志打印切面
 *
 * @author anchao
 * @date 2020/3/4 14:04
 */
@Aspect
@Slf4j
@Component
public class LogPrintAspect {

    @Pointcut("@annotation(com.ac.leader.annotation.LogPrint)")
    public void pointcut() {
    }

    /**
     * 日志打印超时警告
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object target = proceedingJoinPoint.getTarget();
        long start = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = target.getClass().toString()+"-->"+method.getName();
        Parameter[] parameters = method.getParameters();
        LogPrint logPrint = method.getAnnotation(LogPrint.class);
        try {
            log.info("before methodName={},parameters={}",methodName,parameters);
            Object proceed = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            Long time = (end - start)/1000;
            if(time>logPrint.timeOut()){
                log.warn("after timeOut={}, methodName={}",time,methodName);
            }
            log.info("after methodName={},parameters={},returnValue={}", method.getName(),parameters,proceed);
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("LogPrintAspect around error",throwable);
        }
        return null;
    }


}
