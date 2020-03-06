package com.ac.leader.service.impl;

import com.ac.leader.dao.LeaderDao;
import com.ac.leader.entity.Leader;
import com.ac.leader.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author anchao
 * @date 2020/3/5 20:27
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderDao leaderDao;

    @Override
    public List<Leader> list() {
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Leader> all = leaderDao.findAll();
        return all;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Leader save(Leader leaderNew) {
        leaderDao.save(leaderNew);
        return leaderNew;
    }
}
