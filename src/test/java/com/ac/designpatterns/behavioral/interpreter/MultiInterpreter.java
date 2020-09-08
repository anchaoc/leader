package com.ac.designpatterns.behavioral.interpreter;

/**
 * 乘法解释器实现
 *
 * @author anchao
 * @date 2020/9/8 14:51
 **/
public class MultiInterpreter implements Interpreter {
    private Interpreter firstExpression, secondExpression;

    public MultiInterpreter(Interpreter firstExpression, Interpreter secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() * this.secondExpression.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}
