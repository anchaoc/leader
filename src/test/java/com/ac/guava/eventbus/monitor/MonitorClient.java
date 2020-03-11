package com.ac.guava.eventbus.monitor;

import com.google.common.eventbus.EventBus;

/**
 * @author anchao
 * @date 2020/3/11 16:43
 */
public class MonitorClient {


    public static void main(String[] args) throws Exception {
        EventBus eventBus = new EventBus();
        eventBus.register(new FileChangeListener());
        TargetMonitor targetMonitor = new DirectoryTargetMonitor(eventBus, "D:\\monitor");
        targetMonitor.startMonitor();

    }
}
