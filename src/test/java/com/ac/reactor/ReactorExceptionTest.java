package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;

/** 异常演示
 * @author anchao
 * @date 2020/3/6 16:37
 */
@Slf4j
public class ReactorExceptionTest {


    @Test
    public void error() {
        Flux.range(-2, 5).map(i -> {
            int c = i / i;
            return i;
        })
        //发生异常 记录下来 继续执行
        .onErrorContinue((ex, val) -> {
            log.error("error={},val={}", ex, val);
        })
        .subscribe(System.out::println);



    }
}
