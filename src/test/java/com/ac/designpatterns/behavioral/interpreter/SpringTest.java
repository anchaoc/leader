package com.ac.designpatterns.behavioral.interpreter;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Spring 表达式解释器
 * @author anchao
 * @date 2020/9/8 15:26
 **/
public class SpringTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("100 * 100");
        Object value = expression.getValue();
        System.out.println(":"+value);
    }
}
