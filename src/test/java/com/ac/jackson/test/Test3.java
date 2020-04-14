package com.ac.jackson.test;

import com.ac.jackson.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author anchao
 * @date 2020/4/14 14:23
 **/
public class Test3 {


    @Test
    public void whenSerializingUsingJsonIgnoreProperties_thenCorrect()  throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonIgnoreType_thenCorrect()  throws JsonProcessingException, ParseException {
        User.Name name = new User.Name("John", "Doe");
        User user = new User(1, name);
        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);
    }
    @Test
    public void whenSerializingUsingJsonInclude_thenCorrect()  throws JsonProcessingException {
        MyBean bean = new MyBean(1, null);
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
    @Test
    public void whenSerializingUsingJsonAutoDetect_thenCorrect()  throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(1, "My bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonFormat_thenCorrect() throws JsonProcessingException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);
        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }
    @Test
    public void whenSerializingUsingJsonUnwrapped_thenCorrect()  throws JsonProcessingException, ParseException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Doe");
        UnwrappedUser user = new UnwrappedUser(1, name);
        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);
    }


}
