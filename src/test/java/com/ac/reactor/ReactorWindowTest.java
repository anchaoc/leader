package com.ac.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

/** window窗户 嵌套
 * @author anchao
 * @date 2020/3/6 17:56
 */
public class ReactorWindowTest {

    @Test
    public void window(){

        Flux<String> stringFlux = Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i");
        Flux<Flux<String>> fluxFlux = stringFlux.window(2);
        //嵌套数量
        fluxFlux.count().subscribe(System.out::println);
        Flux<Flux<Flux<String>>> fluxFlux3 = fluxFlux.window(3);
        //嵌套数量
        fluxFlux3.count().subscribe(System.out::println);

    }
}
