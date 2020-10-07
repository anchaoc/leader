package com.ac.spring;

import com.ac.LeaderApplication;
import com.ac.common.util.LogUtil;
import com.ac.leader.config.application.SpringContext;
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

   // @Autowired
  //  private SpringContext springContext;

    @Test
    public void testInitBean(){
        Object getPerson = SpringContext.getBean("getPerson");
        LogUtil.printLog(getPerson.toString());
    }
}
