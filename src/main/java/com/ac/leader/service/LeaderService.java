package com.ac.leader.service;

import com.ac.leader.entity.Leader;

import java.util.List;

/**
 * @author anchao
 * @date 2020/3/5 20:26
 */
public interface LeaderService {

    List<Leader> list(Leader leader);

    Leader save(Leader leaderNew);
}
