package com.ac.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anchao
 * @date 2020/5/26 14:19
 **/
public class ThreadLocalSingleton {
    private static final ThreadLocal<Map> THREAD_LOCAL = ThreadLocal.withInitial(HashMap::new);
}
