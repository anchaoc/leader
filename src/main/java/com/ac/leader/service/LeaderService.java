package com.ac.leader.service;

import com.ac.leader.entity.Leader;
import com.ac.leader.model.vo.LeaderVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author anchao
 * @date 2020/3/5 20:26
 */
public interface LeaderService extends IService<Leader> {

    List<Leader> list(LeaderVO leadervo);

    Leader ins(Leader leaderNew);
}
