package com.ac.reactor;

import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

/** disposable停止Flux流
 * @author anchao
 * @date 2020/3/6 19:49
 */
public class ReactorDisposableTest {


    @Test
    public void disposable() throws InterruptedException {
        Flux<Long> longFlux = Flux.interval(Duration.ofMillis(1));
        //获取前50个数据
        Disposable disposable= longFlux.take(50).subscribe(s ->System.out.println("-->"+s));
        //终止flux流
        Thread.sleep(100);
        disposable.dispose();
        System.out.println("main stop-->");
    }
}
