package com.example.springBoot.service.impl;

import com.example.springBoot.dao.Shiro;
import com.example.springBoot.model.ShiroUser;
import com.example.springBoot.model.User;
import com.example.springBoot.service.ShiroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Resource
    private Shiro shiro;


    @Override
    public ShiroUser getUserByName(String name) {
        return shiro.getUserByName(name);
    }
}
