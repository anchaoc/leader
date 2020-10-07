package com.ac.common.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/10/7 15:13
 **/
@Slf4j
public class LogUtil {

    public static void printLog(String logStr) {
        log.info("->" + logStr);
    }

    public static void printWarnLog(String logStr) {
        log.warn("->" + logStr);
    }

    public static void printErrorLog(String logStr) {
        log.error("->" + logStr);
    }
}
