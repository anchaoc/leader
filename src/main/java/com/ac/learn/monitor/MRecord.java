package com.ac.learn.monitor;

import lombok.Data;

/**
 * 监控结果
 **/
@Data
public class MRecord {
    /**
     * 主机Host
     */
    private String host;
    /**
     * 监控key
     */
    private String key;
    /**
     * 方法耗时
     */
    private Long elapsed;
    /**
     * 方法执行是否成功
     */
    private Boolean success = true;

    public MRecord(String key) {
        this.key = key;
    }
}