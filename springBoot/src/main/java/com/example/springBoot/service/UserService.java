package com.example.springBoot.service;

import com.example.springBoot.model.User;

import java.util.List;

/**
 * @author Yihui
 * 2022/9/3
 */
public interface UserService {
    /**
     * 登录用户
     * @param user
     * @return 查询到用户就返回用户，反之则返回null
     */
    public User loginUser(User user);

    /**
     * 注册用户
     * @param user
     * @return 返回1则添加用户成功，其他则不成功
     */
    public int registerUser(User user);

    /**
     * 判断是否存在此用户
     * @param user
     * @return 若存在则返回用户，反之则返回null
     */
    public User containsUser(User user);

    /**
     * 得到所有用户信息
     */
    public List<User> getUsers(Integer start, Integer pageSize);
}
