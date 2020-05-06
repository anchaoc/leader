package com.ac.jdkresources.util.collection;

import java.util.BitSet;

/** bit位set集合 替代List<Boolean>
 * @author anchao
 * @date 2020/5/6 14:46
 **/
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        for (int i=0;i<1000;i++){
            bitSet.set(1);
        }
        int cardinality = bitSet.cardinality();
        System.out.println(cardinality);
    }
}
