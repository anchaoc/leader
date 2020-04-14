package com.ac.jackson.test;

import com.ac.jackson.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

/** 反序列化
 * @author anchao
 * @date 2020/4/14 13:49
 **/
@Slf4j
public class JacksonTest2 {

    @Test
    public void jsonTest4() throws JsonProcessingException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
        log.info("-->bean:[{}]",bean);
    }

    @Test
    public void whenDeserializingUsingJsonInject_thenCorrect() throws IOException {
        String json = "{\"name\":\"My bean\"}";
        InjectableValues inject = new InjectableValues.Std().addValue(BigDecimal.class, BigDecimal.valueOf(66.67));
        BeanWithInject bean = new ObjectMapper().reader(inject).forType(BeanWithInject.class).readValue(json);
        log.info("-->bean:[{}]",bean);
    }

    @Test
    public void whenDeserializingUsingJsonAnySetter_thenCorrect()  throws IOException {
        String json = "{\"name\":\"My bean\",\"one\":\"val2\",\"two\":\"val1\"}";
        ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class).readValue(json);
        log.info("-->bean:[{}]",bean);
    }

    @Test
    public void whenDeserializingUsingJsonSetter_thenCorrect()  throws IOException {
        String json = "{\"id\":1,\"name\":\"My bean\"}";
        MyBean bean = new ObjectMapper().readerFor(MyBean.class).readValue(json);
        log.info("-->bean:[{}]",bean);
    }

    @Test
    public void whenDeserializingUsingJsonDeserialize_thenCorrect()  throws IOException {
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
        Event event = new ObjectMapper().readerFor(Event.class).readValue(json);
        log.info("-->event:[{}]",event);

    }
    @Test
    public void whenDeserializingUsingJsonAlias_thenCorrect() throws IOException {
        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
        AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);
        log.info("-->aliasBean:[{}]",aliasBean);

    }




}
