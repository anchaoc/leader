package com.ac.designpatterns.behavioral.interpreter;

/**
 * @author anchao
 * @date 2020/9/8 15:01
 **/
public final class OperatorUtil {
    private OperatorUtil() {
    }

    /**
     * 是否可操作
     * @param symbol
     * @return
     */
    public static boolean isOperator(String symbol){
        return (symbol.equals("+") || symbol.equals("*"));
    }

    /**
     * 获取对应解释器
     * @param firstExpression
     * @param secondExpression
     * @param symbol
     * @return
     */
    public static Interpreter getExpressionObject(Interpreter firstExpression,Interpreter secondExpression,String symbol){
        if (symbol.equals("+")) {
            return new AddInterpreter(firstExpression,secondExpression);
        }else if(symbol.equals("*")){
            return new MultiInterpreter(firstExpression,secondExpression);
        }
        return null;
    }
}
