package com.ac.guava.collections;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/** 流式转换 FluentIterable
 * @author anchao
 * @date 2020/3/7 17:29
 */
public class FluentIterableExample {


    private FluentIterable<String>  build() {
        ArrayList<String> arrayList = Lists.newArrayList("Ac", "Wang", "Guava", "Scala");
        return FluentIterable.from(arrayList);
    }


    //类似jdk8stream流
    @Test
    public void test(){
        FluentIterable<String> fit = build();
        FluentIterable<String> filter = fit.filter(t -> t != null && t.length() > 4);
        System.out.println(filter);
        assertThat(filter.size(),equalTo(2));
    }


    //append 追加元素
    @Test
    public void testAppend(){
        FluentIterable<String> fit = build();
        ArrayList<String> arrayList = Lists.newArrayList("APPEND");

        FluentIterable<String> append = fit.append(arrayList);
        FluentIterable<String> append2 = append.append("APPEND2");
        System.out.println(append2);
    }

    //match 匹配
    @Test
    public void testMatch(){
        FluentIterable<String> fit = build();
        //所有元素都要满足条件
        boolean result1 = fit.allMatch(t -> t != null && t.length() >= 2);
        System.out.println(result1);
        //其中一个元素满足条件
        boolean result2 = fit.anyMatch(t -> t != null && t.length() >4);
        System.out.println(result1);
        //取出第一个满足条件的
        Optional<String> stringOptional = fit.firstMatch(t -> t != null && t.length() > 4);
        System.out.println(stringOptional.get());
    }

    //取第一个&最后一个
    @Test
    public void testFirst$Last(){
        FluentIterable<String> fit = build();
        Optional<String> first = fit.first();
        System.out.println(first.get());

        Optional<String> last = fit.last();
        System.out.println(last.get());
    }

    //limit 取多少条
    @Test
    public void testLimit(){
        FluentIterable<String> fit = build();
        FluentIterable<String> limit = fit.limit(200);
        System.out.println(limit);
    }

    //拷贝进一个集合
    @Test
    public void testCopyIn(){
        FluentIterable<String> fit = build();
        ArrayList<String> arrayList = Lists.newArrayList("Java");
        ArrayList<String> arrayList1 = fit.copyInto(arrayList);
        System.out.println(arrayList1);
    }

    //不断循环
    @Test
    public void testCycle(){
        FluentIterable<String> fit = build();
        //不断循环 知道筹够20个
        FluentIterable<String> cycle = fit.cycle().limit(20);
        System.out.println(cycle);
    }

    //转变 (数据类型转化) transform
    @Test
    public void testTransform() {
        FluentIterable<String> fit = build();
        FluentIterable<Integer> transform = fit.transform(t -> t.length());
        System.out.println(transform);
    }

    //转换 拼接 transformAndConcat
    @Test
    public void testTransformAndConcat() {
        FluentIterable<String> fit = build();

        //可以理解为 根据参数 fit 返回不同的集合 arrayList 最总结果合成为一个集合
        FluentIterable<String> integers = fit.transformAndConcat(this::search);
        System.out.println(integers);
    }
    //检索
    private ArrayList<String> search(String e) {
        if(e.length()>4){
            return  Lists.newArrayList("满足长度大于4的集合");
        }else{
            return  Lists.newArrayList("不满足长度大于4的集合");
        }
    }

    //join 拼接
    @Test
    public void testJoin() {
        FluentIterable<String> fit = build();
        String join = fit.join(Joiner.on(","));
        System.out.println(join);

    }



}
