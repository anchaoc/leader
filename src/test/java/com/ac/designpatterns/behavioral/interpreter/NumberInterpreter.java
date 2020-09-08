package com.ac.designpatterns.behavioral.interpreter;

/**
 * 数值解释器实现
 * @author anchao
 * @date 2020/9/8 14:55
 **/
public class NumberInterpreter implements Interpreter {
    private int number;

    public NumberInterpreter(int number) {
        this.number = number;
    }
    public NumberInterpreter(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return this.number;
    }
}
