package com.ac.mongo.junit;

import com.ac.LeaderApplication;
import com.ac.mongo.entity.EmployeeDocument;
import com.ac.mongo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

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
    private EmployeeService employeeService;
    @Resource
    private MongoTemplate mongoTemplate;


    /**
     * 添加
     */
    @Test
    public void save(){
        EmployeeDocument employeeDocument = EmployeeDocument.builder().name("anchao").age(25).build();
        EmployeeDocument employeeDocumentSave = employeeService.save(employeeDocument);
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
        List<EmployeeDocument> employeeDocumentList = employeeService.delete(criteriaList, EmployeeDocument.class);
        System.out.println(employeeDocumentList);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        EmployeeDocument employeeDocument = EmployeeDocument.builder().name("jack").age(10).build();
        Criteria criteria = Criteria.where("name");
        criteria.is("xiaohua");
        List<Criteria> criteriaList = Arrays.asList(criteria);
        Long update = employeeService.update(criteriaList, employeeDocument);
        System.out.println(update);
    }



    /**
     * example查询
     */
    @Test
    public void queryByExample(){
        EmployeeDocument employeeDocument = EmployeeDocument.builder().name("anchao").age(25).build();
        Criteria criteria = Criteria.byExample(employeeDocument);
        List<Criteria> criteriaList = Arrays.asList(criteria);
        List<EmployeeDocument> list = employeeService.queryList(criteriaList, EmployeeDocument.class);
        System.out.println(list);

    }

    /**
     * 去重条件查询
     */
    @Test
    public void queryMany(){
        Criteria criteria = new Criteria();
        Criteria age1 = Criteria.where("age").gt(24);
        Criteria age2 = Criteria.where("age").lte(25);
        criteria.andOperator(age1,age2);
        Query query = new Query(criteria);
       // List<Map> mapList = mongoTemplate.find(query, Map.class, "employee");
        List<String> mapList2 = mongoTemplate.findDistinct(query, "name","employee", String.class);
        //System.out.println(mapList);
        System.out.println(mapList2);

    }


    //综合条件查询 分组 去重 排序 ...
    @Test
    public void specialQuery(){
//        MatchOperation matchOperation= Aggregation.match(criteria);
//        SortOperation sortOperation = Aggregation.sort(Sort.by("age").descending());
//        List<AggregationOperation> aggregationOperations = Arrays.asList(matchOperation, sortOperation);
//        Aggregation aggregation = Aggregation.newAggregation(aggregationOperations);
//        AggregationResults<EmployeeDocument> aggregate = mongoTemplate.aggregate(aggregation,"employee", EmployeeDocument.class);
      //  EmployeeDocument employeeDocument = EmployeeDocument.builder().name("anchao").age(25).build();
        //Criteria criteria = Criteria.where("name");
       // criteria.in("anchao");
       // Query query = new Query(criteria);
        //List<EmployeeDocument> mapList = mongoTemplate.findDistinct(query, "age", "employee", EmployeeDocument.class);

//        DistinctIterable<Integer> distinct = mongoTemplate.getCollection("employee").distinct("age", Integer.class);
//        MongoCursor<Integer> iterator = distinct.iterator();
//        Integer next = iterator.next();
//        System.out.println(next);

//
//        DistinctIterable<String> distinct = mongoTemplate.getCollection("employee").distinct("name", String.class);
//        ArrayList<String> into = distinct.into(Lists.newArrayList());
//        System.out.println(into);
//        MongoClient mongoClient = new MongoClient("127.0.0.1",20001);
//        MongoDatabase test = mongoClient.getDatabase("test");
//        MongoCollection<Document> employee = test.getCollection("employee");
//        FindIterable<Document> documents = employee.find();
//        ArrayList<Document> into = documents.into(Lists.newArrayList());
//        System.out.println(into);
//       mongoClient.close();
    }



}
