package com.ac.guava.functional;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.ServerSocket;

/** 函数式
 * @author anchao
 * @date 2020/3/7 16:36
 */
public class FunctionExample {


    public static void main(String[] args) throws IOException {
        Function<String, Integer> function = new Function<String, Integer>() {

            @Nullable
            @Override
            public Integer apply(@Nullable String input) {
                Preconditions.checkNotNull(input, "The input should not be null .");
                return input.length();
            }


        };
        System.out.println(function.apply("hello"));
        process("Hello",new Handler.LengthDoubleHandler());

        String str = Functions.toStringFunction().apply(new ServerSocket(9999));
        System.out.println(str);


    }


    interface  Handler<IN,OUT>{
        OUT handle(IN input);

        class LengthDoubleHandler implements Handler<String,Integer>{

            @Override
            public Integer handle(String input) {
                return input.length()*2;
            }
        }
    }


    private static void process(String text,Handler<String,Integer> handler){
        System.out.println(handler.handle(text));

    }



}
