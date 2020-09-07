package com.ac.designpatterns.behavioral.command;

/**
 * 行为型--命令模式(将命令封装成对象，以便使用不同的请求)
 * @author anchao
 * @date 2020/9/7 17:42
 **/
public class Test {

    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("<<行为型--命令模式>>");
        OpenCourseVideo openCourseVideo = new OpenCourseVideo(courseVideo);
        CloseCourseVideo closeCourseVideo = new CloseCourseVideo(courseVideo);
        Staff staff = new Staff();
        staff.addCommand(openCourseVideo);
        staff.addCommand(closeCourseVideo);
        staff.executeCommands();
    }
}
