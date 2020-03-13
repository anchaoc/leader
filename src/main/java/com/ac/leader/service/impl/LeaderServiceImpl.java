package com.ac.leader.service.impl;

import com.ac.leader.dao.LeaderDao;
import com.ac.leader.entity.Leader;
import com.ac.leader.monitor.LogPrint;
import com.ac.leader.service.LeaderService;
import com.ac.redis.constant.RedisCacheConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @LogPrint
    @Override
    @Cacheable(cacheNames= RedisCacheConstant.LEADER_CACHE_NAME,key = "'"+RedisCacheConstant.LEADER_KEY+"'",unless ="#result==null")
    public List<Leader> list() {

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
