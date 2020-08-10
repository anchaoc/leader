package com.ac.designpatterns.behavioral.state;

/**
 *  当前状态是播放，可以切换到其它状态
 * @author anchao
 * @date 2020/8/10 14:25
 **/
public class PlayState extends CourseVideoState {
    @Override
    public void play() {
        System.out.println("正常播放课程视频的状态");
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);

    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }
}
