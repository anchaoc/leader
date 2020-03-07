package com.ac.guava.utilities;

import com.ac.guava.base.GuavaBaseTest;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;


/** 功能丰富拼接
 * @author anchao
 * @date 2020/3/7 12:18
 */
public class JoinerTest extends GuavaBaseTest {



    private final List<String> stringList = Arrays.asList("Google","Guava","Java","FastJson");

    private final List<String> stringListWithNullValue = Arrays.asList("Google","Guava","Java",null);

    private final String targetFileName ="D:\\qrcode\\guava-joiner.txt";
    private final String targetFileNameTomap ="D:\\qrcode\\guava-joiner-map.txt";

    private final Map<String,String> stringMap = ImmutableMap.of("Hello","Guava","Java","Scala");



    //元素拼接
    @Test
    public void testOnJoin(){
        String result = Joiner.on("#").join(stringList);
        System.out.println(print+result);
       assertThat(result,equalTo("Google#Guava#Java#FastJson"));
    }

    //元素拼接 跳过null
    @Test
    public void testOnJoinWithNullValue(){
        String result = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        System.out.println(print+result);
        assertThat(result,equalTo("Google#Guava#Java"));
    }

    //元素拼接 有null替换默认值
    @Test
    public void testOnJoin_WithNullValue_But_UseDefaultValue(){
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringListWithNullValue);
        System.out.println(print+result);
        assertThat(result,equalTo("Google#Guava#Java#DEFAULT"));
    }

    //拼接到StringBuilder中
    @Test
    public void testJoin_On_Append_To_StringBuilder(){
        // TODO 返回的实例与放入的实例是一个
        StringBuilder stringBuilder1 = Joiner.on("#").useForNull("DEFAULT")
                .appendTo(new StringBuilder(), stringListWithNullValue);
        System.out.println(print+stringBuilder1.toString());
        assertThat(stringBuilder1.toString(),equalTo("Google#Guava#Java#DEFAULT"));
    }


    //拼接完成写入文件
    @Test
    public void testJoin_On_Append_To_Writer(){
        try(FileWriter writer = new FileWriter(new File(targetFileName))){

            FileWriter fileWriter = Joiner.on("#")
                    .useForNull("DEFAULT")
                    .appendTo(writer, stringListWithNullValue);

            assertThat(writer,sameInstance(fileWriter));

            assertThat(Files.isFile().test(new File(targetFileName)),equalTo(true));
        }catch (IOException ex){
            fail("append to the writer occur fetal error .");
        }
    }

    //jdk8 stream处理拼接 跳过null
    @Test
    public void testJoiningByStreamSkipNullValue(){

        String collect = stringListWithNullValue.stream()
                .filter(item -> item != null && !item.isEmpty())
                .collect(Collectors.joining("#"));

        System.out.println(print+collect);

        assertThat(collect,equalTo("Google#Guava#Java"));

    }

    //jdk8 stream处理拼接 设置null 的默认值
    @Test
    public void testJoiningByStreamWithDefaultValue() {

        String collect = stringListWithNullValue.stream()
                .map(this::getDefaultValue)
                .collect(Collectors.joining("#"));

        System.out.println(print+collect);

        assertThat(collect,equalTo("Google#Guava#Java#JDK8_DEFAULT"));

    }
    private String getDefaultValue(final String item) {
        return item ==null || item.isEmpty()?"JDK8_DEFAULT":item;
    }

    //map拼接成字符串
    @Test
    public void testJoinOnWIthMap(){
        String str = Joiner.on("#").withKeyValueSeparator("=").join(stringMap);
        System.out.println(print+str);
        assertThat(str,equalTo("Hello=Guava#Java=Scala"));
    }

    //map拼接成字符串 写入文件
    @Test
    public void testJoinOnWIthMapToAppendable(){

        try(FileWriter writer = new FileWriter(new File(targetFileNameTomap))){

            FileWriter fileWriter = Joiner.on("#")
                    .withKeyValueSeparator("=")
                    .appendTo(writer, stringMap);

            assertThat(writer,sameInstance(fileWriter));

            assertThat(Files.isFile().test(new File(targetFileNameTomap)),equalTo(true));
        }catch (IOException ex){
            fail("append to the writer occur fetal error .");
        }
    }


}
