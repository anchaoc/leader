package com.ac.guava.utilities;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author anchao
 * @description
 * @date 2020/4/12 15:20
 **/
public class BloomFilterTest {

    /**
     * 布隆过滤器
     *
     */
    @Test
    public void boolmFilterTest(){
        List<Long> longList = Arrays.asList(1L, 2L);
        BloomFilter<Long> longBloomFilter = BloomFilter.create(Funnels.longFunnel(), longList.size());
        longList.forEach(longBloomFilter::put);
        //如果其中存在
        if (longBloomFilter.mightContain(2L)) {
            System.out.println("包含");
        }else System.out.println("不包含");

        if (longList.contains(2L)) {
            System.out.println("包含");
        }
    }
}
