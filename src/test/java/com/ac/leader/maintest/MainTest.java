package com.ac.leader.maintest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.function.Function;
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
        int page = 1;
        int size = 10;

        HashMap<String, Object> hashMap1 = Maps.newHashMap();
        hashMap1.put("1", 1);
        hashMap1.put("2", 2);
        hashMap1.put("3", 3);
        hashMap1.put("4", 4);
        hashMap1.put("5", 1);
        hashMap1.put("6", 2);
        hashMap1.put("7", 3);
        hashMap1.put("8", 4);
        hashMap1.put("9", 1);
        hashMap1.put("10", 2);
        hashMap1.put("11", 3);
        hashMap1.put("12", 4);
        hashMap1.put("uid", 120);
        ArrayList<Map<String, Object>> list1 = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            list1.add(hashMap1);
        }

        HashMap<String, Object> hashMap2 = Maps.newHashMap();
        hashMap2.put("a", "a");
        hashMap2.put("b", "b");
        hashMap2.put("c", "c");
        hashMap2.put("d", "d");
        hashMap2.put("e", "a");
        hashMap2.put("f", "b");
        hashMap2.put("g", "c");
        hashMap2.put("h", "d");
        hashMap2.put("i", "a");
        hashMap2.put("j", "b");
        hashMap2.put("k", "c");
        hashMap2.put("l", "d");
        hashMap2.put("uid", 120);

        ArrayList<Map<String, Object>> list2 = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            list2.add(hashMap2);
        }

        List<Map<String, Object>> finallyList = byLambda(list1, list2);

        System.out.println(finallyList.stream().skip((page - 1) * size).limit(10000).collect(Collectors.toList()));
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

    //for
    private static void byForeach(ArrayList<Map<String, Object>> list1, ArrayList<Map<String, Object>> list2) {
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
    }

    //lambda
    private static List<Map<String, Object>> byLambda(ArrayList<Map<String, Object>> list1, ArrayList<Map<String, Object>> list2) {
        Map<String, Map<String, Object>> functionMap = list2.stream().collect(Collectors.toMap(t -> t.get("uid").toString(), Function.identity(), (v1, v2) -> v2));
        return list1.stream().map(s1 -> {
            if (functionMap.keySet().contains(s1.get("uid").toString())) {
                s1.putAll(functionMap.get(s1.get("uid").toString()));
            }
            return s1;
        }).collect(Collectors.toList());
    }




}
