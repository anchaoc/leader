package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

/** flux嵌套 加delayElements(延时)会打乱顺序
 * @author anchao
 * @date 2020/3/6 16:54
 */
@Slf4j
public class ReactorFlatMapTest {



    @Test
    public void flatMap() throws InterruptedException {
        Flux<String> stringFlux = Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i");
        Flux<Flux<String>> fluxFlux = stringFlux.window(2);
        fluxFlux.flatMap(f->f.map(w->w.toUpperCase()).delayElements(Duration.ZERO)).subscribe(System.out::println);
        Thread.sleep(3000);

    }


}
