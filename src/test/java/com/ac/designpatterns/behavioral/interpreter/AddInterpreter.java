package com.ac.designpatterns.behavioral.interpreter;

/**
 * 加法解释器实现
 * @author anchao
 * @date 2020/9/8 14:47
 **/
public class AddInterpreter implements Interpreter{
    private Interpreter firstExpression, secondExpression;

    public AddInterpreter(Interpreter firstExpression, Interpreter secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        //参数相加
        return this.firstExpression.interpret()+this.secondExpression.interpret();
    }

    @Override
    public String toString() {
        return "+";
    }
}
