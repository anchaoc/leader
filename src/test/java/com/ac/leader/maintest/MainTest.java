package com.ac.leader.maintest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2020/3/6 22:44
 */
public class MainTest {

    public static void main(String[] args) {
        intersection();
    }

    //多条件查询
    private static void intersection() {
        long start = System.currentTimeMillis();
        int page =1;
        int size =10;

        HashMap<String, Object> hashMap1 = Maps.newHashMap();
        hashMap1.put("1", 1);
        hashMap1.put("2", 2);
        hashMap1.put("3", 3);
        hashMap1.put("4", 4);
        hashMap1.put("uid", 120);
        ArrayList<Map<String, Object>> list1 = Lists.newArrayList(hashMap1);

        HashMap<String, Object> hashMap2 = Maps.newHashMap();
        hashMap2.put("a", "a");
        hashMap2.put("b", "b");
        hashMap2.put("c", "c");
        hashMap2.put("d", "d");
        hashMap2.put("uid", 120);

        ArrayList<Map<String, Object>> list2 = Lists.newArrayList(hashMap2);

        ListIterator<Map<String, Object>> mapListIterator = list1.listIterator();
        while (mapListIterator.hasNext()) {
            Map<String, Object> map1 = mapListIterator.next();
            List<Map<String, Object>> mapList = list2.stream()
                    .filter(s -> s.get("uid").equals(map1.get("uid"))).collect(Collectors.toList());
            if(!mapList.isEmpty() && mapList.size()>0){
                Map<String, Object> map2 = mapList.get(0);
                if (map2 != null)
                    map1.putAll(map2);
                else
                    mapListIterator.remove();
            }else  mapListIterator.remove();
        }
        System.out.println( list1.stream().skip((page-1)*size).limit(10).collect(Collectors.toList()));
        long end = System.currentTimeMillis();
        System.out.println((end-start));


    }
}
