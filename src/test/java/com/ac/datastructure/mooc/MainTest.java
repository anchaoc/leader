package com.ac.datastructure.mooc;

/**
 * @author anchao
 * @date 2020/12/9 19:06
 **/
public class MainTest {

    public static void main(String[] args) {
        AcArray<Integer> acArray = new AcArray<Integer>(5);
        for (int i =0; i<10;i++){
            acArray.addLast(i);
        }
        System.out.println(acArray);
        acArray.add(1,100);
        System.out.println(acArray);
        acArray.addFirst(-1);
        System.out.println(acArray);
        acArray.remove(2);
        System.out.println(acArray);
        acArray.removeElement(-1);
        System.out.println(acArray);
        acArray.removeLast();
        System.out.println(acArray);


    }
}
