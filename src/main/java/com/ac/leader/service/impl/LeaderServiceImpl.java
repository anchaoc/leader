package com.ac.leader.service.impl;

import com.ac.leader.dao.LeaderDao;
import com.ac.leader.entity.Leader;
import com.ac.leader.service.LeaderService;
import com.ac.leader.model.vo.LeaderVO;
import com.ac.redis.constant.RedisCacheConstant;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author anchao
 * @date 2020/3/5 20:27
 */
@Service
public class LeaderServiceImpl extends ServiceImpl<LeaderDao,Leader>  implements LeaderService {

    @Resource
    private LeaderDao leaderDao;

    @Override
    @Cacheable(cacheNames= RedisCacheConstant.LEADER_CACHE_NAME,key = "#root.target.getFormatKey(#leadervo)",unless = "#result==null || #result.size()==0")
    public List<Leader> list(LeaderVO leadervo) {
        LambdaQueryWrapper<Leader> leaderQuery = Wrappers.lambdaQuery();
        leaderQuery.eq(!paramIsNull(leadervo.getLeaderAddress()),Leader::getLeaderAddress,leadervo.getLeaderAddress());
        leaderQuery.eq(!paramIsNull(leadervo.getLeaderLevel()),Leader::getLeaderLevel,leadervo.getLeaderLevel());
        leaderQuery.eq(!paramIsNull(leadervo.getLeaderAge()),Leader::getLeaderAge,leadervo.getLeaderAge());
        leaderQuery.eq(!paramIsNull(leadervo.getLeaderName()),Leader::getLeaderName,leadervo.getLeaderName());
        List<Leader> all = leaderDao.selectList(leaderQuery);
        return all;
    }

    /**
     * 验证参数为空
     * @param o
     * @return
     */
    private boolean paramIsNull(Object o) {
        return org.springframework.util.StringUtils.isEmpty(o);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Leader ins(Leader leaderNew) {
        leaderDao.insert(leaderNew);
        return leaderNew;
    }

    /**
     * redis 缓存key
     */
    public String getFormatKey(LeaderVO leadervo){
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = leadervo.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, fields[i].getName());
                Method method = leadervo.getClass().getMethod("get" +name);
                Object result = method.invoke(leadervo);
                stringBuilder = (result == null || org.springframework.util.StringUtils.isEmpty(result))
                        ? stringBuilder.append(StringUtils.EMPTY) : stringBuilder.append("leader."+fields[i].getName()+"."+result);
            }
            System.out.println("------->"+stringBuilder.toString());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
