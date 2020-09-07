package com.ac.designpatterns.behavioral.command;

/**
 * 课程视频
 * @author anchao
 * @date 2020/9/7 17:43
 **/
public class CourseVideo {
    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open(){
        System.out.println(this.name+"课程视频开放");
    }

    public void close(){
        System.out.println(this.name+"课程视频关闭");
    }
}
