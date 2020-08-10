package com.ac.designpatterns.behavioral.state;

/**
 *  行为型--状态模式
 * @author anchao
 * @date 2020/8/10 14:41
 **/
public class Test {

    public static void main(String[] args) {
        CourseVideoContext courseVideoContext = new CourseVideoContext();
        courseVideoContext.setCourseVideoState(new PlayState());
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());
        courseVideoContext.pause();
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());
        courseVideoContext.speed();
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());
        courseVideoContext.stop();
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());
        courseVideoContext.speed ();
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());

    }
}
