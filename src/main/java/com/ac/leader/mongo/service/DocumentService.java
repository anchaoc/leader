package com.ac.leader.mongo.service;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

/**
 * 通用mongobd服务
 * @author anchao
 * @date 2020/3/4 12:42
 */
public interface DocumentService<T> {

    /**
     * 添加到mongodb
     */
    T save (T t);

    /**
     * 多条件查询s
     */
    List<T> queryList(List<Criteria> criterias,Class<T> tClass);

    /**
     * 条件删除
     */
    List<T> delete(List<Criteria> criterias, Class<T> aClass);
}
