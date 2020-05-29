package com.ac.designpatterns.creational.singleton;

/** 枚举单例
 * @author anchao
 * @date 2020/5/27 14:16
 **/
public enum EnumSingleton {
    INSTANCE{
        protected void print(String s){
            System.out.println("打印："+s);
        }
    };
    protected abstract void print(String str);

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
