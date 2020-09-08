package com.ac.designpatterns.behavioral.interpreter;

import java.util.Stack;

/**
 * 表达式 解释器
 * @author anchao
 * @date 2020/9/8 14:58
 **/
public class AnchaoExpressionParser {
    private Stack<Interpreter> stack = new Stack<Interpreter>();

    public int parse(String str){
        String[] strItemArray = str.split(" ");
        for (String symbol : strItemArray) {
            //不是运算符号，是数值
            if (!OperatorUtil.isOperator(symbol)) {
                Interpreter numberExpression = new NumberInterpreter(symbol);
                stack.push(numberExpression);
                System.out.printf("入栈：%d%n",numberExpression.interpret());
            }
            //是运算符号，可以计算
            else{
                Interpreter firstExpression = stack.pop();
                Interpreter secondExpression = stack.pop();
                System.out.printf("出栈：%d %d %n",firstExpression.interpret(),secondExpression.interpret());
                Interpreter operator = OperatorUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                System.out.printf("应用运算符：%s%n",operator);
                int result = operator.interpret();
                NumberInterpreter numberInterpreter = new NumberInterpreter(result);
                stack.push(numberInterpreter);
                System.out.printf("结果入栈：%d%n",numberInterpreter.interpret());
            }
        }
        return stack.pop().interpret();
    }
}
