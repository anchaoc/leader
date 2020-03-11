package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.ExceptionListener;
import com.google.common.eventbus.EventBus;

/** 异常事件测试
 * @author anchao
 * @date 2020/3/11 12:14
 */
public class ExceptionEventBusExample {


    public static void main(String[] args) {
        final EventBus eventBus = new EventBus((ex,co)->{
            System.out.println(co.getEvent());
            System.out.println(co.getEventBus());
            System.out.println(co.getSubscriber());
            System.out.println(co.getSubscriberMethod());
            System.out.println(ex);
        });
        eventBus.register(new ExceptionListener());
        eventBus.post("exception post");
    }


//    //监听遇到异常时 进入处理
//    static class ExceptionHandler implements SubscriberExceptionHandler{
//
//        @Override
//        public void handleException(Throwable exception, SubscriberExceptionContext context) {
//            System.out.println(context.getEvent());
//            System.out.println(context.getEventBus());
//            System.out.println(context.getSubscriber());
//            System.out.println(context.getSubscriberMethod());
//        }
//
//    }
}
