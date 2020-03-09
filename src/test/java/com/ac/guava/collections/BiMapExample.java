package com.ac.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/** bi map
 * @author anchao
 * @date 2020/3/9 19:08
 */
public class BiMapExample {


    //value 不可重复
    @Test
    public void testBiMapCreateAndPut(){
        //java.lang.IllegalArgumentException: value already present: 2
        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("1", "2");
        biMap.put("3", "2");
        System.out.println(biMap);
    }

    //biMap key value 反转
    @Test
    public void testBiMapInverse(){
        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("1", "2");
        biMap.put("2", "3");
        biMap.put("3", "4");
        System.out.println(biMap);
        BiMap<Object, Object> inverse = biMap.inverse();
        System.out.println(inverse);
    }

    // 当value已经被put过 强制put
    @Test
    public void testBiMapForcePut(){
        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("1", "2");
        biMap.forcePut("2", "2"); //强制put
        //{2=2}
        System.out.println(biMap);
    }


}
