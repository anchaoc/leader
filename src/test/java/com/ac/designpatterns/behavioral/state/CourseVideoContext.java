package com.ac.designpatterns.behavioral.state;

/**
 * @author anchao
 * @date 2020/8/10 14:16
 **/
public class CourseVideoContext {
    private CourseVideoState courseVideoState;
    public static final PlayState PLAY_STATE = new PlayState();
    public static final StopState STOP_STATE = new StopState();
    public static final PauseState PAUSE_STATE = new PauseState();
    public static final SpeedState SPEED_STATE = new SpeedState();

    public CourseVideoState getCourseVideoState() {
        return courseVideoState;
    }

    public void setCourseVideoState(CourseVideoState courseVideoState) {
        this.courseVideoState = courseVideoState;
        this.courseVideoState.setCourseVideoContext(this);
    }

    public void play(){
        this.courseVideoState.play();
    }
    public void stop(){
        this.courseVideoState.stop();
    }
    public void pause(){
        this.courseVideoState.pause();
    }
    public void speed(){
        this.courseVideoState.speed();
    }



}
