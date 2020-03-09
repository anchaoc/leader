package com.ac.guava.collections;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

/** 范围
 * @author anchao
 * @date 2020/3/9 20:01
 */
public class RangeExample {

    //定义范围
    //？。。？范围的值 (小..大) （a<=x<=b）
    @Test
    public void testCloseRange() {
        //包含最大最小
        Range<Integer> closed = Range.closed(0, 9);
        //[0..9]
        System.out.println(closed);
        System.out.println(closed.lowerEndpoint());
        //true
        System.out.println(closed.contains(0));
        System.out.println(closed.contains(9));
    }

    //定义范围
    //？。。？范围的值 (小..大) （a<x<b）
    @Test
    public void testOpenRange() {
        //不包含最大最小
        Range<Integer> open = Range.open(0, 9);
        System.out.println(open);
        //false
        System.out.println(open.contains(0));
        //false
        System.out.println(open.contains(9));
    }

    //定义范围
    //open close
    @Test
    public void testOpen$CloseRange() {
        //（a<x<=b）
        Range<Integer> openClosed = Range.openClosed(0, 9);
        //(0..9]
        System.out.println(openClosed);

        Range<Integer> closedOpen = Range.closedOpen(0, 9);
        //[0..9) （a<=x<b）
        System.out.println(closedOpen);
    }

    //定义范围
    //最大开始 最小开始
    @Test
    public void testGreaterThan$LessThanRange() {
        Range<Integer> greaterThan = Range.greaterThan(10);
        //(10..+∞)
        System.out.println(greaterThan);
        Range<Integer> lessThan = Range.lessThan(10);
        //(-∞..10)
        System.out.println(lessThan);

    }

    //其他方法
    @Test
    public void testOtherRange() {
        //最小..
        Range<Integer> atLeast = Range.atLeast(2);
        //[2..+∞)
        System.out.println(atLeast);

        Range<Integer> lessThan = Range.lessThan(5);
        //(-∞..5)
        System.out.println(lessThan);

        Range<Integer> atMost = Range.atMost(5);
        //(-∞..5]
        System.out.println(atMost);

        Range<Comparable<?>> all = Range.all();
        //(-∞..+∞)
        System.out.println(all);
        //降低..
        Range<Integer> downTo = Range.downTo(10, BoundType.CLOSED);
        //[10..+∞)
        System.out.println(downTo);
        //上升..
        Range<Integer> upTo = Range.upTo(10, BoundType.OPEN);
        //(-∞..10)
        System.out.println(upTo);
    }

    ////按范围KEY取对应的值
    @Test
    public void testRangeMap(){
        TreeRangeMap<Integer, String> treeRangeMap = TreeRangeMap.create();
        treeRangeMap.put(Range.closed(0,60),"F");
        treeRangeMap.put(Range.closed(61,70),"E");
        treeRangeMap.put(Range.closed(71,80),"D");
        treeRangeMap.put(Range.closed(81,90),"C");
        treeRangeMap.put(Range.closed(91,100),"B");
        String s = treeRangeMap.get(77);
        System.out.println(s);

    }
}