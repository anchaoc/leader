package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * flux mono 发布 订阅
 * @author anchao
 * @date 2020/3/6 13:35
 */
@Slf4j
public class ReactorCreateTest {

    public static void main(String[] args) {
        //createFlux();
        //createMono();
       //subscribe();

    }


    /**
     * 订阅
     */
    private static void subscribe() {

        Flux<String> stringFlux = Flux.just("hello", "world");

        //一次订阅
        stringFlux.subscribe(v ->{
            log.info("val={}",v);
        },e->{
            log.error("error",e);
        },()->{
            log.info("over");
        },sub -> {
            sub.request(1);
        });

        //二次订阅
        stringFlux.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                log.info("onNext={}",s);
            }

            @Override
            public void onError(Throwable t) {
                log.info("onError",t);
            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }
        });
    }


    /**
     * mono(只保存0-1个对象)
     * 创建mono
     */
    private static void createMono() {
        //发布
        Mono<String> stringMono = Mono.just("hello world");
        Mono<String> stringMono1 = Mono.fromCallable(() -> "hello world");
        Mono<String> stringMono2 = Mono.fromFuture(CompletableFuture.completedFuture("hello world"));
        Random random =new Random(6);
        Mono<Integer> integerMono = Mono.fromSupplier(random::nextInt);
        Mono<Integer> integerMono1 = Mono.from(Flux.range(1, 5));
        //订阅
        stringMono.subscribe(System.out::println);
        stringMono1.subscribe(System.out::println);
        integerMono1.subscribe(System.out::println);

    }


    /**(可以保存0-N个对象)
     * 创建flux
     */
    private static void createFlux() {

        //发布
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
        Flux<String> stringFlux = Flux.just("hello", "world");
        List<String> stringList = Arrays.asList("hello", "world");
        Flux<String> fromIterable = Flux.fromIterable(stringList);
        Flux<Integer> range = Flux.range(1, 10);
        //订阅
        stringFlux.subscribe(System.out::println);
        integerFlux.subscribe(System.out::println);
        fromIterable.subscribe(System.out::println);
        range.subscribe(System.out::println);



    }


}
