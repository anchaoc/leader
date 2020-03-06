package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**StepVerifier 单元测试
 * @author anchao
 * @date 2020/3/6 20:14
 */
@Slf4j
public class ReactorStepVerifierTest {




    @Test
    public void stepVerifier(){

        Flux<Integer> integerFlux = Flux.range(1, 5);
        integerFlux.subscribe(s->System.out.println("->"+s));
        StepVerifier.create(integerFlux).
                expectNext(1)
                .expectNext(2)
                .expectNext(3,4,5)
                .expectComplete().verify();
    }


}
