package com.ac.leader.mongo.dao;

import com.ac.leader.mongo.entity.EmployeeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author anchao
 * @date 2020/3/4 12:41
 */
public interface EmployeeDao extends MongoRepository<EmployeeDocument,String> {
}
