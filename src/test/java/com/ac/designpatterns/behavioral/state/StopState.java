package com.ac.designpatterns.behavioral.state;

/**
 * @author anchao
 * @date 2020/8/10 14:26
 **/
public class StopState extends CourseVideoState {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.err.println("ERROR: 停止状态不能快进");
    }

    @Override
    public void pause() {
        System.err.println("ERROR: 停止状态不能暂停");
    }

    @Override
    public void stop() {
        System.out.println("停止播放课程视频的状态");
    }
}
