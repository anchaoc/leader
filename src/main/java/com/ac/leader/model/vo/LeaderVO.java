package com.ac.leader.model.vo;

import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author anchao
 * @date 2020/3/5 17:16
 */
@NoArgsConstructor
public class LeaderVO implements Serializable {

    private Long id ;

    private String leaderName;

    private Integer leaderAge;

    private Integer leaderSex;

    private String leaderAddress;

    private Integer leaderLevel;



    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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
