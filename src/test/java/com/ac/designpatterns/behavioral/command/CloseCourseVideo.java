package com.ac.designpatterns.behavioral.command;

/**
 * @author anchao
 * @date 2020/9/7 17:46
 **/
public class CloseCourseVideo implements Command{
    private CourseVideo courseVideo;
    @Override
    public void execute() {
        this.courseVideo.close();
    }

    public CloseCourseVideo(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }
}
