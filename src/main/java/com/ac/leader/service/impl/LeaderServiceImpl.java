package com.ac.leader.service.impl;

import com.ac.leader.dao.LeaderDao;
import com.ac.leader.entity.Leader;
import com.ac.leader.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author anchao
 * @date 2020/3/5 20:27
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderDao leaderDao;

    @Override
    public List<Leader> list(Leader leader) {
        List<Leader> all = leaderDao.findAll();
        return all;
    }

    @Override
    @Transactional(value = "transactionManager",rollbackFor = Exception.class)
    public Leader save(Leader leaderNew) {
        leaderDao.save(leaderNew);
        return leaderNew;
    }
}
