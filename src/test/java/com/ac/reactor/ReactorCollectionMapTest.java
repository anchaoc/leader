package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/** flux转换mono map
 * @author anchao
 * @date 2020/3/6 17:40
 */
@Slf4j
public class ReactorCollectionMapTest extends ReactorMapTest {

    @Test
    public void collectionMap(){
        Flux<Employee> employeeFlux = Flux.fromIterable(list);
        Mono<Map<String, Double>> mapMono = employeeFlux.collectMap(key -> key.getName(), value -> value.getSalary());
        mapMono.subscribe(System.out::println);
    }
}
