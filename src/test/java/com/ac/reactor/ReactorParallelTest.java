package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * parallel并行多线程
 * @author anchao
 * @date 2020/3/6 19:59
 */
@Slf4j
public class ReactorParallelTest {

    @Test
    public void parallel(){
        Flux<Integer> integerFlux = Flux.range(1, 10);

        integerFlux
                .parallel() //线程数 默认根据CPU数计算
                .runOn(Schedulers.parallel())
                .subscribe(x->log.info("->"+x));

    }
}
