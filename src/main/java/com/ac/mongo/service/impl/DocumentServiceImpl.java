package com.ac.mongo.service.impl;

import com.ac.leader.annotation.LogPrint;
import com.ac.mongo.dao.EmployeeDao;
import com.ac.mongo.entity.EmployeeDocument;
import com.ac.mongo.service.DocumentService;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author anchao
 * @date 2020/3/4 12:42
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class DocumentServiceImpl implements DocumentService<EmployeeDocument> {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private EmployeeDao employeeDao;


    @Override
    @LogPrint
    public EmployeeDocument save(EmployeeDocument employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    @LogPrint
    public List<EmployeeDocument> queryList(List<Criteria> criterias, Class<EmployeeDocument> aClass) {
        //多条件拼接
        Query query = getQuery(criterias);
        List<EmployeeDocument> employeeDocumentList = mongoTemplate.find(query, aClass);
        return employeeDocumentList;
    }

    @Override
    @LogPrint
    public List<EmployeeDocument> delete(List<Criteria> criterias, Class<EmployeeDocument> aClass) {
        Query query = getQuery(criterias);
        List<EmployeeDocument> allAndRemove = mongoTemplate.findAllAndRemove(query, EmployeeDocument.class);
        log.info("DocumentServiceImpl delete() employeeDocumentDeleteResult-->{}",allAndRemove);
        return allAndRemove;
    }

    @Override
    public Long update(List<Criteria> criterias,EmployeeDocument t) {
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
