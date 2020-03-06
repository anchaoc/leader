package com.ac.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

/** flux转化mono 集合
 * @author anchao
 * @date 2020/3/6 17:30
 */
@Slf4j
public class ReactorCollectionTest extends ReactorMapTest{

    @Test
    public void collection(){
        Flux<Integer> integerFlux = Flux.range(1, 5);
        Mono<List<Integer>> listMono = integerFlux.collectList();
        listMono.subscribe(System.out::println);

        Flux<Employee> employeeFlux = Flux.fromIterable(list);
        Mono<List<Employee>> listMono1 = employeeFlux.collectSortedList(Comparator.comparing(Employee::getSalary).reversed());
        listMono1.subscribe(System.out::println);

    }

}
