package com.ac.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

/** take 条件获取
 * @author anchao
 * @date 2020/3/6 17:48
 */
public class ReactorTakeTest {

    @Test
    public void take(){

        //获取前5个
        Flux<Integer> integerFlux = Flux.range(1, 10);
        integerFlux.take(5).subscribe(System.out::println);

        //获取1毫秒产生的数据
        Flux<Integer> integerFlux1 = Flux.range(1, 1000);
        integerFlux1.take(Duration.ofMillis(1)).subscribe(System.out::println);

        //一直订阅到5
        Flux<Integer> integerFlux2 = Flux.range(1, 10);
        integerFlux2.takeUntil(i -> i == 5).subscribe(System.out::println);


    }

}
