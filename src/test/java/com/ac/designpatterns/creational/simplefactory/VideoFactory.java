package com.ac.designpatterns.creational.simplefactory;

/**
 * @author anchao
 * @date 2020/5/29 16:06
 **/
public class VideoFactory {


    public static Video getVideo(Class c){
        Video video = null;
        try {
            video = (Video) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return video;
    }


    public static Video getVideo(String type){
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        }else if("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        throw new RuntimeException("not found type video");
    }

}
