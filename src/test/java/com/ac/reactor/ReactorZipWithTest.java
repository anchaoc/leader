package com.ac.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

/**
 * 压缩成一个flux
 * @author anchao
 * @date 2020/3/6 18:01
 */
public class ReactorZipWithTest {

    @Test
    public void zipWith(){
        //两两压缩合并 不足一对则抛弃
        Flux<String> stringFlux1 = Flux.just("a", "b", "c", "d","i");
        Flux<String> stringFlux2 = Flux.just("e", "f", "g", "h");
        Flux<String> stringFlux3 = Flux.just("1", "2", "3", "4");
        stringFlux1.zipWith(stringFlux2).subscribe(System.out::println);

        //两两压缩合并 不足一对则抛弃
        Flux<Tuple2<String, String>> zip = Flux.zip(stringFlux1, stringFlux2);
        zip.subscribe(System.out::println);

        //三个为一组压缩合并 不足一对则抛弃
        Flux<Tuple3<String, String, String>> tuple3Flux = Flux.zip(stringFlux1, stringFlux2, stringFlux3);
        tuple3Flux.subscribe(System.out::println);


    }

}
