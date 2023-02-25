package com.example.springBoot.dao;

import com.example.springBoot.model.ShiroUser;
import com.example.springBoot.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface Shiro {
    /**
     * 通过用户名获取用户
     */
    ShiroUser getUserByName(String name);
}
