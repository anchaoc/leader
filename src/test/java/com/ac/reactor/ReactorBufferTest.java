package com.ac.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.List;

/** buffer 缓冲放置 为集合
 * @author anchao
 * @date 2020/3/6 18:10
 */
public class ReactorBufferTest {




    @Test
    public void buffer(){
        Flux<String> stringFlux = Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i");
        Flux<List<String>> buffer = stringFlux.buffer(2);
        buffer.subscribe(b->System.out.print("-->"+b));
    }
}
