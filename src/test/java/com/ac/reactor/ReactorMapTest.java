package com.ac.reactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/**
 * map转换
 * @author anchao
 * @date 2020/3/6 15:59
 */
@Slf4j
public class ReactorMapTest {

    protected List<Employee> list = Arrays.asList(new Employee("anchao",5000),new Employee("hongda",6000));

    @Test
    public void map(){
        Flux<Employee> employeeFlux = Flux.fromIterable(list);
         employeeFlux.log().filter(s -> s.getSalary() == 5000).log().map(s -> {
            Leader leader = new Leader();
            leader.setName(s.getName());
            leader.setSalary(s.getSalary());
            return leader;
        }).subscribe(System.out::println);
    }




    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Leader{
        private String name;
        private double salary;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Employee{
        private String name;
        private double salary;
    }
}
