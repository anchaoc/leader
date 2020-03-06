package com.ac.reactor;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author anchao
 * @date 2020/3/6 18:43
 */
public class ReactorBaseTest {

    protected static ThreadLocal<List<Long>> threadLocal;




    public static void set(Long a){

        if(threadLocal==null || threadLocal.get().isEmpty() || threadLocal.get().size()<=0){
            threadLocal = new ThreadLocal<>();
            threadLocal.set(Lists.newArrayList(a));
        }else{
            threadLocal.get().add(a);
        }
    }


    public static List<Long> get(){
       return threadLocal.get();
    }
}
