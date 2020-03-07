package com.ac.guava.utilities;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/** 秒表记录
 * @author anchao
 * @date 2020/3/7 17:02
 */
@Slf4j
public class ElapsedExample {

    public static void main(String[] args) throws InterruptedException {
        process("36694932001");
    }

    private static void process(String orderNo) throws InterruptedException {
        log.info("start process the order {}\n",orderNo);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.MILLISECONDS.sleep(1);
        log.info("The orderNo [{}] process successful and elapsed [{}]",orderNo,stopwatch.stop());
    }
}
