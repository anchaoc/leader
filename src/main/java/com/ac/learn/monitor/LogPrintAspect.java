package com.ac.learn.monitor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetAddress;
import java.net.UnknownHostException;

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

    @Pointcut("@annotation(com.ac.learn.monitor.LogPrint)")
    public void pointcut() {
    }

    /**
     * 日志打印超时警告
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("LogPrint");
        Object target = proceedingJoinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Parameter[] args = method.getParameters();
        LogPrint logPrint = method.getAnnotation(LogPrint.class);
        MRecord mRecord = getmRecord(target, method, logPrint);
        return getresult(proceedingJoinPoint, stopWatch, args, logPrint, mRecord);
    }


    /**
     * 获取返回值
     */
    private Object getresult(ProceedingJoinPoint proceedingJoinPoint
            , StopWatch stopWatch, Parameter[] args
            , LogPrint logPrint, MRecord mRecord) {
        Object result;
        try {
            //拼接输入参数
            StringBuilder inputLog = new StringBuilder();
            inputLog.append(mRecord.getKey()).append(", [input]");
            if (null != args && args.length > 0) {
                for (Object object : args) {
                    inputLog.append(object).append(",");
                }
                inputLog.deleteCharAt(inputLog.length() - 1);
            }
            //打印输入参数
            if (logPrint.printInput()) {
                log.info(inputLog.toString());
            }

            result = proceedingJoinPoint.proceed();

            stopWatch.stop();
            mRecord.setElapsed(stopWatch.getTotalTimeMillis());

            //拼接并打印输出参数
            StringBuilder out = new StringBuilder();
            out.append(inputLog);
            if (logPrint.printOutput()) {
                out.append(" ,[output] ").append(result)
                        .append(", [host]").append(mRecord.getHost());
            }
            if (logPrint.printTimeCost()) {
                out.append(", [time consuming]").append(stopWatch.getTotalTimeSeconds());
            }
            log.info(out.toString());
            return result;
        } catch (Throwable throwable) {
            mRecord.setSuccess(false);
            log.error("LogPrintAspect around error", throwable);
            throw new RuntimeException(throwable);
        } finally {
            if (stopWatch.getTotalTimeSeconds() > logPrint.timeOut()) {
                log.warn("{}:Timeout! Alarm timeout:{}ms, host:{}, elapsed:{}ms, success:{}",
                        mRecord.getKey(), mRecord.getElapsed(), mRecord.getHost(), mRecord.getElapsed(), mRecord.getSuccess());
            } else {
                log.info("{}:Normal.host:{}, elapsed:{}ms, success:{}", new Object[]{mRecord.getKey(), mRecord.getHost(), mRecord.getElapsed(), mRecord.getSuccess()});
            }
        }
    }

    /**
     * 获取监控结果
     */
    private MRecord getmRecord(Object target, Method method, LogPrint logPrint) {
        MRecord mRecord;
        if (StringUtils.isBlank(logPrint.key())) {
            String key = target.getClass().toString() + "." + method.getName();
            mRecord = new MRecord(key);
        } else {
            mRecord = new MRecord(logPrint.key());
        }
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            mRecord.setHost(host);
        } catch (UnknownHostException e) {
            if (log.isInfoEnabled()) {
                log.info("can not get the host!", e);
            }
        }
        return mRecord;
    }
}
