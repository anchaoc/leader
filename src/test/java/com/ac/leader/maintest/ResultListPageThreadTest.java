package com.ac.leader.maintest;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**多线程任务
 * 按数据量计算线程数
 * 控制在十个线程以内
 * @author anchao
 * @date 2020/4/1 17:17
 */
public class ResultListPageThreadTest {
    @Test
    public void pageTest(){
        long count =500000;
        long fixedNum =computeFixedNum(count);
        long totalPage = (long) Math.ceil((double)count/fixedNum);
        final CountDownLatch downLatch = new CountDownLatch(((int)totalPage));
        ExecutorService executorService = Executors.newFixedThreadPool(((int)totalPage));
        for (long i = 1; i <= totalPage; i++) {
            Map<String, Long> stringLongMap = computePage(i, fixedNum);
            executorService.execute(()->print(stringLongMap,downLatch));
        }
        try {
            downLatch.await();
            System.out.println("---->多线程任务执行完成,主线程开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算固定线程数
     */
    private long computeFixedNum(long count) {
        if(count<=0){
            System.err.println("--->数量异常.");
            return 0;
        }
        else if(count<10000) return 1000;
        else if(count<50000) return 5000;
        else if(count<100000) return 10000;
        else if(count<200000) return 20000;
        else if(count<300000) return 30000;
        else if(count<400000) return 40000;
        else if(count<500000) return 50000;
        else if(count<600000) return 60000;
        else if(count<700000) return 70000;
        else if(count<800000) return 80000;
        else if(count<900000) return 90000;
        else return 100000;
    }

    /**
     * 执行任务
     */
    private void print(Map<String, Long> stringLongMap, CountDownLatch downLatch) {
        Long pagenum = stringLongMap.get("PAGENUM");
        Long pagesize = stringLongMap.get("PAGESIZE");
        Long skipcount = stringLongMap.get("SKIPCOUNT");
        System.out.println("-->当前页:"+pagenum);
        System.out.println("-->跳过数:"+skipcount);
        System.out.println("-->每页条数:"+pagesize);
        System.out.println("-->线程:"+Thread.currentThread().getName()+"开始执行");
        try {
            TimeUnit.NANOSECONDS.sleep(pagesize);
            System.out.println("-->线程:"+Thread.currentThread().getName()+"执行完成");
            downLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 计算分页参数
     * 当前页 每页条数 跳过条数
     */
    private Map<String,Long> computePage(long pageNum, long pageSize) {
        HashMap<String, Long> map = Maps.newHashMap();
        if(pageNum<=0){
            pageNum=1;
        }
        if(pageSize<=0){
            pageSize=Long.MAX_VALUE;
        }
        long skipCount = (pageNum-1)*pageSize;
        map.put("PAGENUM",pageNum);
        map.put("PAGESIZE",pageSize);
        map.put("SKIPCOUNT",skipCount);
        return map;
    }
}
