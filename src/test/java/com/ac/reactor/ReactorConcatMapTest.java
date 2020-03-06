package com.ac.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * flux嵌套 拼接
 * @author anchao
 * @date 2020/3/6 17:05
 */
public class ReactorConcatMapTest {

    @Test
    public void concatMap() throws InterruptedException {

        Flux<Integer> stringFlux = Flux.just(1, 2, 4, 3, 8, 6,7, 5,9);
        Flux<Flux<Integer>> fluxFlux = stringFlux.window(2);
        fluxFlux.concatMap(flux ->flux.map(c->c.intValue())
                .delayElements(Duration.ZERO))
                .subscribe(x->System.out.print("-->"+x));
        Thread.sleep(2000);
    }
}
