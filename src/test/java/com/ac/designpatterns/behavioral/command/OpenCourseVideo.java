package com.ac.designpatterns.behavioral.command;

/**
 * @author anchao
 * @date 2020/9/7 17:46
 **/
public class OpenCourseVideo implements Command {
    private CourseVideo courseVideo;
    @Override
    public void execute() {
        this.courseVideo.open();
    }
    public OpenCourseVideo(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }
}
