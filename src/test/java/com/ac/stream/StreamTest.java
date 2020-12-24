package com.ac.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2020/3/29 23:16
 */
@Slf4j
public class StreamTest {

    @Data
    @AllArgsConstructor
    class User{
        private Long id;
        private String name;
        private BigDecimal price;
    }

    /**
     * filter
     * 过滤
     */
    @Test
    public void filterTest(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, -1, -2, -3);
        List<Integer> integerList1 = integerList
                .stream()
                .filter(i -> i > 0)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    /**
     * map
     * 数据转换
     */
    @Test
    public void mapTest(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, -1, -2, -3);
        List<String> stringList = integerList
                .stream()
                .map(t -> t.toString())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }


    /**
     * flatMap
     * 多维列表转换单维列表
     */
    @Test
    public void flatMapTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(2L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price);
        List<List<User>> lists = Arrays.asList(Arrays.asList(user1, user2), Arrays.asList(user3, user4));
        List<User> lists2 = lists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(lists2);
    }

    /**
     * sorted
     * 排序
     */
    @Test
    public void sortedTest(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, -1, -2, -3);
        List<Integer> sortedList = integerList
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList);
        Assert.assertNotSame(sortedList, integerList);
    }

    /**
     * min
     * max
     * average
     * 最大最小平均
     */
    @Test
    public void MinMaxAvgTest(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, -1, -2, -3,null);
        Integer min = integerList
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(i->i)
                .min().orElse(100);
        System.out.println(min);
        Integer max = integerList
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(i->i)
                .max()
                .orElse(100);
        System.out.println(max);
        double avg = integerList
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(i -> i)
                .average()
                .orElse(1.00);
        System.out.println(avg);
    }

    /**
     * allMatch
     * anyMatch
     * noneMatch
     * 匹配条件
     */
    @Test
    public void matchTest(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 5, 7, 9,0);
        boolean allMatch = integerList
                .stream()
                .allMatch(i -> i instanceof Integer);
        System.out.println(allMatch);
        boolean anyMatch = integerList
                .stream()
                .anyMatch(i -> i instanceof Integer);
        System.out.println(anyMatch);
        boolean noneMatch = integerList.stream().noneMatch(i -> i <0);
        System.out.println(noneMatch);
    }

    /**jdk
     * 按照整个对象数据值distinct 去重
     */
    @Test
    public void distinctTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(2L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price);
        List<User> lists = Arrays.asList(user1, user2,user3,user4);
        List<User> collect = lists.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    /**streamEx
     * 按照某个属性 distinct 去重
     */
    @Test
    public void distinctByStreamExTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(2L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price);
        List<User> lists = Arrays.asList(user1, user2,user3,user4);
        List<User> collect = StreamEx.of(lists).distinct(User::getPrice).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 压缩
     * reduce
     */
    @Test
    public void reduceTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(2L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price);
        List<User> lists = Arrays.asList(user1,user2,user3,user4);
        BigDecimal bigDecimal = lists
                .stream()
                .map(User::getPrice)
                .reduce(BigDecimal.ONE,BigDecimal::add);
        System.out.println(bigDecimal);
    }

    /**
     * Collectors
     * joining -->拼接
     * toSet
     * toList
     * toMap
     * toCollection -->其他集合
     * summarizingDouble -->同时求出 最大 最小 平均 求和 数量
     * partitioningBy -->true false 条件分组
     * groupingBy -->按某个值分组
     */
    @Test
    public void collectorTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(1L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price);
        List<User> lists = Arrays.asList(user1,user2,user3,user4);
        String nameJoin = lists.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println(nameJoin);
        Set<BigDecimal> priceSet = lists.stream().map(User::getPrice).collect(Collectors.toSet());
        System.out.println(priceSet);
        Vector<User> collect = lists.stream().collect(Collectors.toCollection(Vector::new));
        System.out.println(collect);
        Map<Long, String> collect1 = lists
                .stream()
                .collect(Collectors.toMap(User::getId, User::getName, (v1, v2) -> v2 + "_"));
        System.out.println(collect1);
        DoubleSummaryStatistics summaryStatistics = lists
                .stream()
                .collect(Collectors.summarizingDouble(v -> v.getPrice().doubleValue()));
        System.out.println(summaryStatistics);
        Map<Boolean, List<User>> collect2 = lists.
                stream()
                .collect(Collectors.partitioningBy(v -> v.getPrice().compareTo(BigDecimal.valueOf(13000)) > 0));
        System.out.println(collect2);
        Map<Long, List<User>> collect3 = lists.stream().collect(Collectors.groupingBy(User::getId,Collectors.toList()));
        System.out.println(collect3);
    }

    /**
     * count 计数
     */
    @Test
    public void countTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        BigDecimal price1 = new BigDecimal("14000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(2L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price1);
        List<User> lists = Arrays.asList(user1, user2,user3,user4);
        long count = lists
                .stream()
                .filter(t -> t.getPrice().compareTo(BigDecimal.valueOf(13000)) > 0)
                .count();
        System.out.println(count);
    }

    /**
     * 并发处理
     * parallel
     */
    @Test
    public void parallelTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        BigDecimal price1 = new BigDecimal("14000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(2L, "b", price);
        User user3 = new User(3L, "c", price);
        User user4 = new User(4L, "d", price1);
        List<User> lists = Arrays.asList(user1, user2,user3,user4);
        lists.stream().parallel().forEach(s->{
            try {
                log.info("----->{}",s.getId());
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void CollectorsAndThanTest(){
        BigDecimal price = new BigDecimal("12000.1314");
        BigDecimal price1 = new BigDecimal("14000.1314");
        User user1 = new User(1L, "a", price);
        User user2 = new User(3L, "b", price);
        User user3 = new User(4L, "c", price);
        User user4 = new User(2L, "d", price1);
        List<User> lists = Arrays.asList(user1,user1, user2,user3,user4);
        ArrayList<User> collect = lists.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<User>(Comparator.comparing(User::getId))), ArrayList::new));
        System.out.println(collect);

    }


}
