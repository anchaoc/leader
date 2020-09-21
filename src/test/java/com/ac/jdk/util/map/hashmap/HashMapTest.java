package com.ac.jdk.util.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anchao
 * @date 2020/9/21 16:07
 **/
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> resultHashMap = putMap();
        showHashMap(resultHashMap);

    }

    public static void showHashMap(HashMap<String,Integer> hashMap){
//        for (String key:hashMap.keySet()){
//            System.out.println("key:"+key);
//        }
//        for (Integer value : hashMap.values()) {
//            System.out.println("value:"+value);
//        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            System.out.println("key:"+key);
            Integer value = entry.getValue();
            System.out.println("value:"+value);
        }
//        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> next = iterator.next();
//            String key = next.getKey();
//            System.out.println("key:"+key);
//            Integer value = next.getValue();
//            System.out.println("value:"+value);
//        }
    }

    public static HashMap<String, Integer> putMap(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("anchao", 1);
        hashMap.put("liulei", 2);
        hashMap.put("zhaohan", 3);
        hashMap.put("lanye", 4);
        hashMap.put("yangshuo", 5);
        return hashMap;
    }


}
