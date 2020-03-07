package com.ac.guava.utilities;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.List;

/** google 断言 precondtion
 * @author anchao
 * @date 2020/3/7 14:36
 */
public class preconditionsTest {


    @Test(expected = NullPointerException.class)
    public void testCheckNotNull(){
            checkNotNull(null);
    }

    private void checkNotNull(final List<String> list){
        Preconditions.checkNotNull(list,"The list should not be null");
    }




}
