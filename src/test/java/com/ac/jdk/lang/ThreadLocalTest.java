package com.ac.jdk.lang;

import org.junit.Test;

/** 在并发场景下线程间数据隔离
 *  每个线程中的变量是独立的
 * @author anchao
 * @date 2020/3/30 21:29
 */
public class ThreadLocalTest {
   private static ThreadLocal<String> t = new ThreadLocal<>();


    @Test
    public void threadLocalTest(){
        Demo2 demo2 = new Demo2();
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                this.print(demo2);
            }).start();
        }
    }




    @Test
    public void threadTest() {
        Demo1 demo1 = new Demo1();
        for (int i = 0; i <5 ; i++) {
        new Thread(()->{
            this.print(demo1);
        }).start();
        }
    }



    /**
     * 打印线程-->变量值
     */
    private void print(Demo2 demo2) {
        demo2.setContent(Thread.currentThread().getName()+" 的数据");
        System.out.println("---->线程名称："+Thread.currentThread().getName()+"内容-->"+demo2.getContent());
    }


    /**
     * 打印线程-->变量值
     */
    private  void print(Demo1 demo) {
        synchronized (Demo1.class){
            demo.setContent(Thread.currentThread().getName()+" 的数据");
            System.out.println("---->线程名称："+Thread.currentThread().getName()+"内容-->"+demo.getContent());
        }
    }


    public class Demo2{
        public String getContent() {
            return t.get();
        }
        public void setContent(String content) {
            t.set(content);
        }
    }

    public class Demo1{
        private String content;
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    }
}
