package com.ac.datastructure.mooc.array;

/**
 * 自定义数组
 *
 * @author anchao
 * @date 2020/12/9 18:06
 **/
public class AcArray<E> {

    private E[] data;
    //元素个数
    private int size;


    public AcArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public AcArray() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组最后添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //向数组最前添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //向数组中指定位置插入元素,会移动数组中元素的位置
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("插入时下标违法");
        if (size == data.length)
            this.resize(2 * data.length);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    //根据下标获取数组元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("不合法的下标");
        return data[index];
    }

    //根据下标更新数组中的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("不合法的下标");
        data[index] = e;

    }

    //是否包含元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //根据元素获取元素对应的下标
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除指定索引位置的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("不合法的下标");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;//置空引用
        //缩小容量 Lazy
        if(size == data.length /4  &&  data.length /2 !=0 )
            this.resize(data.length/2);
        return ret;
    }

    //删除数组中首个元素
    public E removeFirst() {
        return this.remove(0);
    }

    //删除数组中尾部元素
    public E removeLast() {
        return this.remove(size - 1);
    }

    //删除指定元素
    public void removeElement(E e) {
        int index = this.find(e);
        if (index != -1) {
            this.remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d，capacity=%d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    //数组容量不足时动态扩容和缩小容量
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }
}
