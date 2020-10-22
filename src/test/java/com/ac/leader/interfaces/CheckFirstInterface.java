package com.ac.leader.interfaces;

import java.util.List;

/**
 * @author anchao
 * @date 2020/4/26 15:28
 **/
public interface CheckFirstInterface<E> {

    E getFirstAndLast(List<E> list);
}
