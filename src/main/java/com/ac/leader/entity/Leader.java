package com.ac.leader.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author anchao
 * @date 2020/3/5 17:16
 */
@Entity
@Table(name = "tb_leader")
@Data
@NoArgsConstructor
public class Leader implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(columnDefinition="varchar(500) comment '领导姓名'")
    private String leaderName;

    @Column(columnDefinition="int(3) comment '领导年龄'")
    private Integer leaderAge;

    @Column(columnDefinition="int(1) default 1 not null comment '领导性别'")
    private Integer leaderSex =1;

    @Column(columnDefinition="varchar(500) comment '领导住址'")
    private String leaderAddress;

    @Column(columnDefinition="int(2) default 1 not null comment '领导等级'")
    private Integer leaderLevel =1;



}
