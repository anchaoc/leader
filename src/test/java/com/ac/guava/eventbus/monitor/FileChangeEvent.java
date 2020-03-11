package com.ac.guava.eventbus.monitor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @author anchao
 * @date 2020/3/11 16:37
 */
@Data
@Slf4j
public class FileChangeEvent {


    private final Path path;

    private final WatchEvent.Kind<?> kind;

    public FileChangeEvent(Path path, WatchEvent.Kind<?> kind) {
        this.path = path;
        this.kind = kind;
    }




}




