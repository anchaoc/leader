package com.ac.jackson.test;

import com.ac.jackson.entity.ResultData;
import com.ac.jackson.entity.ResultData2;
import com.ac.jackson.entity.ResultData3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *  Jackson是一个简单的基于Java的应用库，
 *  可以轻松的将Java对象转换为json对象和xml文档，
 *  同样也可以将json、xml转换为Java对象。
 *  Jackson依赖的jar包较少，简单易用性能高，社区活跃，更新速度快。
 * @author anchao
 * @date 2020/4/14 11:21
 **/
@Slf4j
public class JacksonTest {
    @Test
    public void jsonTest() throws JsonProcessingException {
        ResultData resultData = new ResultData();
        HashMap<String, Object> map = Maps.newHashMap();map.put("age",17);
        resultData.setMap(map);
        resultData.setName("a");
        resultData.setAttrs("{\"attr\":false}");
        String string = new ObjectMapper().writeValueAsString(resultData);
        log.info("-->[{}]",string);
    }
    @Test
    public void jsonTest2() throws JsonProcessingException {
        ResultData2 resultData = new ResultData2();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String string = objectMapper.writeValueAsString(resultData);
        log.info("-->[{}]",string);
    }
    @Test
    public void jsonTest3() throws JsonProcessingException {
        ResultData3 resultData = new ResultData3();
        resultData.setTime(LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(resultData);
        log.info("-->[{}]",string);
    }
}
