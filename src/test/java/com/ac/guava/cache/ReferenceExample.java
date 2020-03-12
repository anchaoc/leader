package com.ac.guava.cache;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** jdk 实现缓存
 * @author anchao
 * @date 2020/3/12 13:11
 */
public class ReferenceExample {


    public static void main(String[] args) {


        int counter = 1;
         List<SoftReference<Ref>> container = new ArrayList<>();
         for (;;)
         {
             int i = counter++;
             container.add(new SoftReference<>(new Ref(i)));
             System.out.println("The ref "+i);
             try {
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }




    }









    private static class Ref{

        private byte[] data= new byte[1024 * 1024];
        private int index;

        public Ref(int index) {
            this.index = index;
        }




        @Override
        protected void finalize() throws Throwable {
           System.out.println("The index GC"+index);
        }
    }

}
