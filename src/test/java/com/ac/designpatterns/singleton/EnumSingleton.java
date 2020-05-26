package com.ac.designpatterns.singleton;

/** 枚举实现单例
 * @author anchao
 * @date 2020/5/26 13:58
 **/
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    EnumSingleton() {
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }



    public static void main(String[] args) {
        EnumSingleton enumSingleton3 =  EnumSingleton.INSTANCE;
        enumSingleton3.setData(new Object());
        EnumSingleton enumSingleton2 =  EnumSingleton.INSTANCE;
        enumSingleton2.setData(new Object());
        System.out.println(enumSingleton3.getData() );
        System.out.println(enumSingleton2.getData() );
        System.out.println(enumSingleton3.getData() == enumSingleton2.getData());
        System.out.println(enumSingleton3.getData() == enumSingleton2.getData());
    }
}
