package com.ac.datastructure.mooc.stack;

/**
 * @author anchao
 * @date 2020/12/16 18:13
 **/
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
