package com.ac.guava.collections;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/** 流式转换
 * @author anchao
 * @date 2020/3/7 17:29
 */
public class FluentIterableExample {


    @Test
    public void test(){
        FluentIterable<String> fit = build();
        assertThat(fit.size(),equalTo(4));

    }

    private FluentIterable<String>  build() {
        ArrayList<String> arrayList = Lists.newArrayList("Anchao", "Wang", "Guava", "Scala");
        return FluentIterable.from(arrayList);
    }
}
