package com.ac.leader.mongo.junit;

import com.ac.leader.LeaderApplication;
import com.ac.leader.mongo.entity.EmployeeDocument;
import com.ac.leader.mongo.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/** mongo工具测试
 * @author anchao
 * @date 2020/3/4 12:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeaderApplication.class)
public class EmployeeJunit {

    @Resource
    private DocumentService<EmployeeDocument> documentService;

    /**
     * 添加
     */
    @Test
    public void save(){
        EmployeeDocument employeeDocument = EmployeeDocument.builder().name("jack").age(10).build();
        EmployeeDocument employeeDocumentSave = documentService.save(employeeDocument);
        System.out.println(employeeDocumentSave);
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        Criteria criteria = Criteria.where("name");
        criteria.in("anchao", "world");
        List<Criteria> criteriaList = Arrays.asList(criteria);
        List<EmployeeDocument> employeeDocumentList = documentService.delete(criteriaList, EmployeeDocument.class);
        System.out.println(employeeDocumentList);
    }




    /**
     * example查询
     */
    @Test
    public void queryByExample(){
        EmployeeDocument employeeDocument = EmployeeDocument.builder().name("anchao").age(25).build();
        Criteria criteria = Criteria.byExample(employeeDocument);
        List<Criteria> criteriaList = Arrays.asList(criteria);
        List<EmployeeDocument> list = documentService.queryList(criteriaList, EmployeeDocument.class);
        System.out.println(list);

    }





}
