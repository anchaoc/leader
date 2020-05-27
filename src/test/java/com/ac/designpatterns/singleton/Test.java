package com.ac.designpatterns.singleton;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author anchao
 * @date 2020/5/27 10:18
 **/
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //序列化
//        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(hungrySingleton);
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton hungrySingletonNew = (HungrySingleton)ois.readObject();
//        System.out.println(hungrySingleton);
//        System.out.println(hungrySingletonNew);
//        System.out.println(hungrySingleton == hungrySingletonNew);
        //序列化
        //反射
//        Class objectClass = HungrySingleton.class;
//        Constructor declaredConstructor = objectClass.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
//        HungrySingleton hungrySingletonNew = (HungrySingleton)declaredConstructor.newInstance();
//        System.out.println(hungrySingleton);
//        System.out.println(hungrySingletonNew);
//        System.out.println(hungrySingleton == hungrySingletonNew);
        //反射
//        Class objectClass  = DoubleCheckLockSingleton.class;
//        Constructor declaredConstructor = objectClass.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        DoubleCheckLockSingleton lazySingletonNew = (DoubleCheckLockSingleton)declaredConstructor.newInstance();
//        DoubleCheckLockSingleton lazySingleton = DoubleCheckLockSingleton.getInstance();
//        System.out.println(lazySingletonNew);
//        System.out.println(lazySingleton);
//        System.out.println(lazySingleton == lazySingletonNew);
        //枚举单例序列化
//        EnumSingleton enumSingleton = EnumSingleton.getInstance();
//        enumSingleton.setData(new Object());
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(enumSingleton);
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        EnumSingleton enumSingletonNew = (EnumSingleton) ois.readObject();
//        Object data = enumSingletonNew.getData();
//        System.out.println(data);
//        System.out.println(enumSingleton.getData());
//        System.out.println(data == enumSingleton.getData());
//        //枚举单例反射创建不支持
//        Class objectClass = EnumSingleton.class;
//        Constructor declaredConstructor = objectClass.getDeclaredConstructor(String.class,int.class);
//        declaredConstructor.setAccessible(true);
//        EnumSingleton enumSingleton = (EnumSingleton)declaredConstructor.newInstance("anchao", 123);
//        EnumSingleton enumSingleton = EnumSingleton.getInstance();
//        enumSingleton.print("测试");
        //开启线程
//        new Thread(()->{
//            ContainerSingleton.putInstance("object",new Object());
//            Object object = ContainerSingleton.getInstance("object");
//            System.out.println(Thread.currentThread().getName()+" object:"+object);
//        }).start();
//        new Thread(()->{
//            ContainerSingleton.putInstance("object",new Object());
//            Object object = ContainerSingleton.getInstance("object");
//            System.out.println(Thread.currentThread().getName()+" object:"+object);
//        }).start();

        ThreadLocalSingleton threadLocalSingleton = ThreadLocalSingleton.getInstance();
        new Thread(()->{
            ThreadLocalSingleton threadLocalSingleton2 = ThreadLocalSingleton.getInstance();
            System.out.println(threadLocalSingleton2);
        }).start();
        System.out.println(threadLocalSingleton);
    }
}
