package com.ac.leader.junit;

import com.ac.LeaderApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author anchao
 * @date 2020/3/5 20:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeaderApplication.class)
public class BaseTest {
}
