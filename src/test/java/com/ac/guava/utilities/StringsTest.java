package com.ac.guava.utilities;

import com.ac.guava.base.GuavaBaseTest;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

/** 字符串工具
 * @author anchao
 * @date 2020/3/7 15:47
 */
public class StringsTest extends GuavaBaseTest {


    @Test
    public void testStringMethod(){
        //空串转null
        String str = Strings.emptyToNull("");

        //null 转 空串
        String str1 = Strings.nullToEmpty(null);

        //算出 公共前缀 后缀
        String str3 = Strings.commonPrefix("hello", "hit");
        String str4 = Strings.commonSuffix("hello", "echo");

        //生成重复
        String str5 = Strings.repeat("Anchao",3);

        //校验
        Strings.isNullOrEmpty(null);

        //最前最后 填充
        String str6 = Strings.padStart("Alex", 6, 'H');
        String str7 = Strings.padEnd("Alex", 5, 'H');


        System.out.println(str);
        System.out.println(str1);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);



        assertThat(str,nullValue());
        assertThat(str1,equalTo(""));
        assertThat(str3,equalTo("h"));
        assertThat(str4,equalTo("o"));
        assertThat(str5,equalTo("AnchaoAnchaoAnchao"));
        assertThat(str6,equalTo("HHAlex"));
        assertThat(str7,equalTo("AlexH"));

    }

    //提供了常量字符集
    @Test
    public void testCharset(){
        Charset charset = Charset.forName("UTF-8");
        Charset charset1= Charsets.UTF_8;
        assertThat(charset1,equalTo(charset));
    }

    //匹配字符
    @Test
    public void testCharMatcher(){
        //匹配字符
        boolean matches = CharMatcher.javaDigit().matches('s');
        System.out.println(matches);
        assertThat(matches,equalTo(false));

        //某字符在字符串中的出现的数量
        int countIn = CharMatcher.is('A').countIn("ANCHAO");
        System.out.println(countIn);
        assertThat(countIn,equalTo(2));

        //替换空格(一堆空格视为一个)
        String collpase = CharMatcher.breakingWhitespace().collapseFrom("      hello  Guava     ", '*');
        System.out.println(collpase);
        assertThat(countIn,equalTo(2));
        assertThat(collpase,equalTo("*hello*Guava*"));

        //剔除空格 数字
        String str = CharMatcher.javaDigit().or(CharMatcher.whitespace()).removeFrom("hello 1234 world");
        System.out.println(str);
        assertThat(str,equalTo("helloworld"));

        //保留空格 数字
        String str2 = CharMatcher.javaDigit().or(CharMatcher.whitespace()).retainFrom("hello 1234 world");
        System.out.println(str2);
        assertThat(str2,equalTo(" 1234 "));


    }

}
