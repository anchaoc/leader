package com.ac.leader.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/** mongo集群分片配置
 * @author anchao
 * @date 2020/3/4 11:49
 */
@Slf4j
@Configuration
@EnableMongoRepositories(basePackages = "com.ac.leader.mongo.dao")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    /**
     * mongodb 事务管理
     * 注解无效时 采用手动 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
     */
    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    /**
     * mongodb数据库名称
     */
    @Override
    protected String getDatabaseName() {
        return database;
    }

    /**
     * 默认host locslhost
     */
    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(uri);
    }
}
