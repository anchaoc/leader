package com.ac.leader.dao;

import com.ac.leader.entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anchao
 * @date 2020/3/5 20:28
 */
public interface LeaderDao extends JpaRepository<Leader,Long> {
}
