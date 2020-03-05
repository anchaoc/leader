package com.ac.mongo.service.base;

import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.NoRepositoryBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * mongo通用服务
 * @author anchao
 * @date 2020/3/4 12:42
 */
@Slf4j
@NoRepositoryBean
public class DocumentServiceImpl<T> implements DocumentService<T> {

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public T save(T employee) {
        mongoTemplate.save(employee);
        return employee;
    }

    @Override
    public List<T> queryList(List<Criteria> criterias, Class<T> aClass) {
        //多条件拼接
        Query query = getQuery(criterias);
        List<T> employeeDocumentList = mongoTemplate.find(query, aClass);
        return employeeDocumentList;
    }

    @Override
    public  List<T> delete(List<Criteria> criterias, Class<T> aClass) {
        Query query = getQuery(criterias);
        List<T> allAndRemove = mongoTemplate.findAllAndRemove(query, aClass);
        log.info("DocumentServiceImpl delete() employeeDocumentDeleteResult-->{}",allAndRemove);
        return allAndRemove;
    }

    @Override
    public Long update(List<Criteria> criterias,T t) {
        Query query = getQuery(criterias);
        Update update = Update.update("name","anchao");
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, t.getClass());
        return updateResult.getModifiedCount();
    }

    /**
     * 多条件构造
     */
    private Query getQuery(List<Criteria> criterias) {
        Query query = new Query();
        criterias.forEach(c -> {
            query.addCriteria(c);
        });
        return query;
    }
}
