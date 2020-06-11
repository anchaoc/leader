package com.ac.hutool;

import cn.hutool.script.ScriptUtil;

import javax.script.CompiledScript;
import javax.script.ScriptException;

/**
 * @author anchao
 * @date 2020/6/11 16:31
 **/
public class ScriptUtilTest {
    public static void main(String[] args) throws ScriptException {
        CompiledScript compile = ScriptUtil.compile("Math.abs(0)>0");
//        SimpleBindings simpleBindings = new SimpleBindings();
//        simpleBindings.put("哈哈", "1");
        Object eval1 = compile.eval();
        System.out.println(eval1);
    }
}
