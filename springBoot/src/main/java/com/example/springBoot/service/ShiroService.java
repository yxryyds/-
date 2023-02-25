package com.example.springBoot.service;


import com.example.springBoot.model.ShiroUser;
import com.example.springBoot.model.User;

public interface ShiroService {
    /**
     * 用户登录
     */
    ShiroUser getUserByName(String name);
}
