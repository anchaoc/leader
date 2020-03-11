package com.ac.guava.eventbus.monitor;

/** 监控
 * @author anchao
 * @date 2020/3/11 14:59
 */
public interface TargetMonitor {


    void startMonitor() throws Exception;

    void stopMonitor() throws Exception;
}
