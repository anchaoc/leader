package com.ac.learn.controller.leader;

import com.ac.common.Result;
import com.ac.learn.controller.base.BaseController;
import com.ac.learn.entity.Leader;
import com.ac.learn.model.dto.LeaderDTO;
import com.ac.learn.service.LeaderService;
import com.ac.shiro.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author anchao
 * @date 2020/3/5 20:31
 */
@Api(tags = "leader api")
@RestController
@RequestMapping("leader")
public class LeaderController extends BaseController {
    @Resource
    private LeaderService leaderService;

    @GetMapping("get")
    @ApiOperation(value = "get",notes = "get api")
    public Result<Boolean> get() {
        SysUser currentUser = getCurrentUser();
        return null;
    }

    @PostMapping("save")
    public void save() {
        Leader leaderNew = new Leader();
        leaderNew.setLeaderName("xiaoming");
        leaderNew.setLeaderAddress("北京昌平");
        leaderNew.setLeaderAge(24);
        Leader leader = leaderService.ins(leaderNew);
        System.out.println(leader);
    }

    @GetMapping("list")
    public Result<Object> list(LeaderDTO leaderVo) {
        Mono<List<Leader>> listMono = Mono.fromSupplier(() -> leaderService.list(leaderVo));
        Result<Object> result = new Result<>();
        listMono.subscribe(s -> {
            result.setData(s);
        });
        return result;
    }
}
