package com.ac.leader.controller.base;

import com.ac.shiro.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.Objects;

/**
 * @author anchao
 * @date 2020/8/10 16:18
 **/
@Slf4j
public abstract class BaseController {
    /**
     * 获取当前登录用户
     * @return 当前登录用户信息
     */
    protected SysUser getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        if (Objects.isNull(subject)) {
            return new SysUser();
        }
        return ((SysUser) subject.getPrincipal());
    }
}
