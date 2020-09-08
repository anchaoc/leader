package com.ac.designpatterns.behavioral.interpreter;

/**
 * 行为型模式：解释器模式(为了解释一种语言而创建的解释器)
 * @author anchao
 * @date 2020/9/8 14:44
 **/
public class Test {

    public static void main(String[] args) {
        String testInputStr ="6 100 11 + *";
        AnchaoExpressionParser anchaoExpressionParser = new AnchaoExpressionParser();
        int resultParse = anchaoExpressionParser.parse(testInputStr);
        System.out.print("解释器结果："+resultParse);

    }
}
