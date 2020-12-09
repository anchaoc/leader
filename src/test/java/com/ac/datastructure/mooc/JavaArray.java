package com.ac.datastructure.mooc;

/** java中的 数组
 * @author anchao
 * @date 2020/12/9 17:52
 **/
public class JavaArray {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i =0;i<arr.length;i++)
            arr[i] = i;

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i <scores.length ; i++)
            System.out.println(scores[i]);
        scores[0] = 110;
        for (int score : scores)
            System.out.println(score);

    }
}
