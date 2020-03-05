package com.ac.mongo.service.impl;

import com.ac.mongo.entity.EmployeeDocument;
import com.ac.mongo.service.EmployeeService;
import com.ac.mongo.service.base.DocumentServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author anchao
 * @date 2020/3/5 23:24
 */
@Service
public class EmployeeServiceImpl extends DocumentServiceImpl<EmployeeDocument> implements EmployeeService {
}
