package com.ac.leader.enums;

import com.ac.leader.interfaces.CheckFirstInterface;

import java.util.List;

/** 枚举实现多个判断
 * @author anchao
 * @date 2020/4/26 13:56
 **/
public enum CheckFirstEnum implements CheckFirstInterface<String> {

    /**
     * 等于
     */
    EQUAL {
        @Override
        public String getFirstAndLast(List<String> list) {
            System.out.println(" = ");
            return null;
        }
    },

    /**
     * 大于
     */
    GT {
        @Override
        public String getFirstAndLast(List<String> list) {
            System.out.println(" > ");
            return null;
        }
    },
    /**
     * 小于
     */
    LT {
        @Override
        public String getFirstAndLast(List<String> list) {
            System.out.println(" < ");
            return null;
        }
    }
}
