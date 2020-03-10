package com.ac.guava.utilities;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/** 秒表
 * @author anchao
 * @date 2020/3/10 16:23
 */
@Slf4j
public class StopWatchExample {

    public static void main(String[] args) throws InterruptedException {
        process("36694932001");
    }

    private static void process(String orderNo) throws InterruptedException {
        log.info("start process the order [{}]",orderNo);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(1);
        log.info("The orderNo [{}] process successful and elapsed [{}]",orderNo,stopwatch.stop());
    }
}
