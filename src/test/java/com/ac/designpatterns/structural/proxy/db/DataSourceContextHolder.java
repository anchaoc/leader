package com.ac.designpatterns.structural.proxy.db;

/**
 * 数据源上下文
 * Created by geely
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDBType(String dbType){
        CONTEXT_HOLDER.set(dbType);
    }
    public static String getDBType(){
        return (String)CONTEXT_HOLDER.get();
    }
    public static void clearDBType(){
        CONTEXT_HOLDER.remove();
    }


}
