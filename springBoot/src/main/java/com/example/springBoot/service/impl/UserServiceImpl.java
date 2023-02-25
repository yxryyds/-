package com.example.springBoot.service.impl;


import com.example.springBoot.dao.UserDao;
import com.example.springBoot.model.User;
import com.example.springBoot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yihui
 * 2022/9/3
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User loginUser(User user) {
        return userDao.getUserByNameAndPassword(user.getUsername(), user.getPassword());
    }
    @Override
    public int registerUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User containsUser(User user) {
        return userDao.getUserByName(user.getUsername());
    }

    /**
     * @param start 当前页
     * @param pageSize 查询的行数
     * @return 查询或的结果
     */
    @Override
    public List<User> getUsers(Integer start, Integer pageSize) {
        log.info("分页查询：start:{}， pageSize:{}", start, pageSize);
        log.info("开启pageHelper功能");
        // 使用pageHelper
        Page<Object> page = PageHelper.startPage(start, pageSize);
        System.out.println(page);
        //获取用户信息
        return userDao.getAll();
    }
}
