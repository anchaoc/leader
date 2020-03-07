package com.ac.guava.utilities;

import com.ac.guava.base.GuavaBaseTest;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 分割工具
 * @author anchao
 * @date 2020/3/7 13:23
 */
public class SplitterTest extends GuavaBaseTest {


    //分割成为 list集合
    @Test
    public void testSplitOnSplit(){
        List<String> stringList = Splitter.on("|").splitToList("hello|world");
        System.out.println(print+stringList);
        assertThat(stringList,notNullValue());
        assertThat(stringList.size(),equalTo(2));
        assertThat(stringList.get(1),equalTo("world"));
        assertThat(stringList.get(0),equalTo("hello"));
    }

    //分割成为 list集合 跳过无元素
    @Test
    public void testSplit_On_Split_OmitEmpty_TrimResult(){

        List<String> stringList2 = Splitter.on("|")
                .omitEmptyStrings()
                .trimResults()
                .splitToList("hello |  world|||");

        System.out.println(print+stringList2);

        assertThat(stringList2,notNullValue());
        assertThat(stringList2.size(),equalTo(2));

        assertThat(stringList2.get(1),equalTo("world"));
        assertThat(stringList2.get(0),equalTo("hello"));
    }

    //按字符长度分割
    @Test
    public void testSplitFixLength(){

        List<String> strings = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");
        System.out.println(print+strings);

        assertThat(strings,notNullValue());
        assertThat(strings.size(),equalTo(4));

        assertThat(strings.get(1),equalTo("bbbb"));
        assertThat(strings.get(0),equalTo("aaaa"));

    }

    //分割 获取某几条
    @Test
    public void testSplitLimit(){

        List<String> stringList = Splitter.on("#").limit(3).splitToList("hello#world#java#google#anchao");
        System.out.println(print+stringList);

        assertThat(stringList,notNullValue());
        assertThat(stringList.size(),equalTo(3));

        assertThat(stringList.get(1),equalTo("world"));
        assertThat(stringList.get(0),equalTo("hello"));

    }

    //分割 匹配正则字符串
    @Test
    public void testSplitOnPatternString(){

        List<String> splitToList = Splitter.onPattern("\\|")
                .trimResults()
                .omitEmptyStrings()
                .splitToList("hello |  world|||");


        System.out.println(print+splitToList);

        assertThat(splitToList,notNullValue());
        assertThat(splitToList.size(),equalTo(2));

        assertThat(splitToList.get(1),equalTo("world"));
        assertThat(splitToList.get(0),equalTo("hello"));

    }

    //分割 匹配正则 为list
    @Test
    public void testSplitOnPattern(){

        List<String> splitToList = Splitter.on(Pattern.compile("\\|"))
                .trimResults()
                .omitEmptyStrings()
                .splitToList("hello |  world|||");


        System.out.println(print+splitToList);

        assertThat(splitToList,notNullValue());
        assertThat(splitToList.size(),equalTo(2));

        assertThat(splitToList.get(1),equalTo("world"));
        assertThat(splitToList.get(0),equalTo("hello"));

    }


    //分割 匹配正则 为map
    @Test
    public void testSplitOnSplitToMap(){

        Map<String, String> splitMap = Splitter.on(Pattern.compile("\\|"))
                .trimResults()
                .omitEmptyStrings()
                .withKeyValueSeparator("-").split("hello-Hello | world-WORLD |||");


        System.out.println(print+splitMap);

        assertThat(splitMap,notNullValue());
        assertThat(splitMap.size(),equalTo(2));

        assertThat(splitMap.containsKey("hello"),equalTo(true));
        assertThat(splitMap.containsKey("world"),equalTo(true));

    }

}
