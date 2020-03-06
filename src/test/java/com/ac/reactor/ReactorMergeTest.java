package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

/** merge交叉合并 concat(追加合并)
 * @author anchao
 * @date 2020/3/6 20:09
 */
@Slf4j
public class ReactorMergeTest {

    @Test
    public void merge() throws InterruptedException {
        Flux<Long> longFlux1 = Flux.interval(Duration.ofMillis(100)).take(10);
        Flux<Long> longFlux2 = Flux.interval(Duration.ofMillis(100)).take(10);
        Flux<Long> longFlux3 = Flux.merge(longFlux1, longFlux2);
        longFlux3.subscribe(System.out::println);
        Thread.sleep(2000);
    }
}
