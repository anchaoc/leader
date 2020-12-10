/*
package com.ac.mongo.service.base;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

*/
/**
 * 通用mongobd服务
 * @author anchao
 * @date 2020/3/4 12:42
 *//*

@NoRepositoryBean
public interface DocumentService<T> {

    */
/**
     * 添加到mongodb
     *//*

    T save(T t);

    */
/**
     * 多条件查询
     *//*

    List<T> queryList(List<Criteria> criterias, Class<T> tClass);

    */
/**
     * 条件删除
     *//*

    List<T> delete(List<Criteria> criterias, Class<T> aClass);

    */
/**
     * 条件修改
     *//*

     Long update(List<Criteria> criterias, T t);
}
*/
