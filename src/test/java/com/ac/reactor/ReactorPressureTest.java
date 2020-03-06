package com.ac.reactor;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;

/** reactor 背压 TODO
 * @author anchao
 * @date 2020/3/6 18:22
 */
public class ReactorPressureTest extends ReactorBaseTest{

    @Test
    public void pressure() throws InterruptedException {

        Flux<Long> longFlux = Flux.interval(Duration.ofMillis(1));

        longFlux.subscribe(new Subscriber<Long>() {
            Subscription subscription;

            @Override
            public void onSubscribe(Subscription s) {
                this.subscription =s;
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Long aLong) {
                perform(2L);
                subscription.request(2);
                System.out.println("val="+aLong);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

           Thread.sleep(10000);

    }

    private void perform(Long aLong) {
        System.out.println("--->"+aLong);
//        ReactorBaseTest.set(aLong);
//        if (ReactorBaseTest.get().size()>2) {
//            throw new OutOfMemoryError();
//        }

    }
}
