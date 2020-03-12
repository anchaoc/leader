package com.ac.leader.junit;

import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author anchao
 * @date 2020/3/12 16:54
 */
public class MonoTest {



    @Test
    public void monoTest() throws InterruptedException {
        Mono<Integer> mono = Mono.fromSupplier(() -> {
            try {
                System.out.println("to do...");
                TimeUnit.SECONDS.sleep(10);
                return 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
        System.out.println("Main thread continues execution ..");
        mono.subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(20);

    }
}
