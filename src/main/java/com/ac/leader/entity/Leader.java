package com.ac.leader.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author anchao
 * @date 2020/3/5 17:16
 */
@TableName("tb_leader")
@NoArgsConstructor
public class Leader implements Serializable {


    @TableField
    private Long id ;

    private String leaderName;

    private Integer leaderAge;

    private Integer leaderSex =1;

    private String leaderAddress;

    private Integer leaderLevel =1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Integer getLeaderAge() {
        return leaderAge;
    }

    public void setLeaderAge(Integer leaderAge) {
        this.leaderAge = leaderAge;
    }

    public Integer getLeaderSex() {
        return leaderSex;
    }

    public void setLeaderSex(Integer leaderSex) {
        this.leaderSex = leaderSex;
    }

    public String getLeaderAddress() {
        return leaderAddress;
    }

    public void setLeaderAddress(String leaderAddress) {
        this.leaderAddress = leaderAddress;
    }

    public Integer getLeaderLevel() {
        return leaderLevel;
    }

    public void setLeaderLevel(Integer leaderLevel) {
        this.leaderLevel = leaderLevel;
    }
}
