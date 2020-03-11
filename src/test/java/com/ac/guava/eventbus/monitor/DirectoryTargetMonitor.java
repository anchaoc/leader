package com.ac.guava.eventbus.monitor;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.WatchService;

/**
 * @author anchao
 * @date 2020/3/11 15:02
 */
@Slf4j
public class DirectoryTargetMonitor implements TargetMonitor {


    private WatchService watchService;

    public DirectoryTargetMonitor(WatchService watchService) {
        this.watchService = watchService;
    }

    @Override
    public void startMonitor() throws Exception {
    }

    @Override
    public void stopMonitor() throws Exception {

    }
}
