package com.ac.datastructure.mooc.stack;


import com.ac.datastructure.mooc.array.AcArray;

/**
 * 基于数组实现栈
 * @author anchao
 * @date 2020/12/16 18:15
 **/
public class ArrayStack<E> implements Stack<E> {

    private final AcArray<E> array;

    public ArrayStack(int capacity) {
        array = new AcArray<>(capacity);
    }

    public ArrayStack() {
        array = new AcArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return null;
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}
