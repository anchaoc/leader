package com.ac.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * @author anchao
 * @date 2020/4/16 10:11
 **/
public class LeaderToken extends UsernamePasswordToken implements Serializable {

    public LeaderToken(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

}
