package com.ac.leader.controller;

import com.ac.leader.entity.Leader;
import com.ac.leader.service.LeaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anchao
 * @date 2020/3/5 20:31
 */
@Api(tags = "leader api")
@Controller
@RequestMapping("leader")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    /**
     * 保存单条
     */
    @ApiOperation("save")
    @GetMapping("save")
    public void save(){
        Leader leaderNew = new Leader();
        leaderNew.setLeaderName("xiaoming");
        leaderNew.setLeaderAddress("北京昌平");
        leaderNew.setLeaderAge(24);
        Leader leader = leaderService.save(leaderNew);
        System.out.println(leader);
    }
}