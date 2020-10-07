package com.ac.spring;

import com.ac.LeaderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author anchao
 * @date 2020/10/7 15:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeaderApplication.class)
public class SpringTest {

    @Test
    public void testInitBean(){
    }
}
