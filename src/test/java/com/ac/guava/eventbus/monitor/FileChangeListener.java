package com.ac.guava.eventbus.monitor;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/11 16:41
 */
@Slf4j
public class FileChangeListener {



    @Subscribe
    public void onChange(FileChangeEvent fileChangeEvent){
        log.info("{}-{}",fileChangeEvent.getPath(),fileChangeEvent.getKind());
    }
}
