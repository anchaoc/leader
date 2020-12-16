package com.ac.jdk.juc.thread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2020/12/14 23:03
 **/
public class LambdaTest {

    public static void main(String[] args) {


        List<String> listStr = Arrays.asList("DDD", "D", "DD","DDDDDDD");
        List<String> collect = listStr.stream().map(String::toLowerCase).sorted((one,two)-> two.length() - one.length()).collect(Collectors.toList());
        System.out.println(collect);


//        List<Integer> elements = Arrays.asList(1, 2, 3, 4,5);
//        Optional<List<Integer>> optionalList = Optional.of(elements);
//        optionalList.ifPresent(System.out::print);
        //List<Integer> integers = Arrays.asList(1, 2, 6, 4, 5, 6, 8,null);
/*        List<String> collect = integers.stream().map(str -> String.valueOf(str+"hello")).collect(Collectors.toList());
        System.out.println(collect);*/




//        List<Integer> collect = integers.stream().filter(a -> {
//            return a >= 2;
//        }).collect(Collectors.toList());
//        System.out.println(collect);
//
//        List<Integer> collect = integers.stream().filter(a -> a >= 2).collect(Collectors.toList());
//        System.out.println(collect);
//
//        List<Integer> collect2 = integers.stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer a) {
//                return a >= 2;
//            }
//        }).collect(Collectors.toList());
//        System.out.println(collect2);
    }
}
