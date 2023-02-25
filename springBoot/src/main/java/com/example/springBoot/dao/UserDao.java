package com.example.springBoot.dao;

import com.example.springBoot.model.DataUser;
import com.example.springBoot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yihui
 * 2022/9/3
 */
@Repository
public interface UserDao {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 查询出用户则返回用户，反之则返回null
     */
    public User getUserByNameAndPassword(@Param("name") String username, @Param("pass") String password);

    /**
     * 根据用户名查询用户
     * @param name
     * @return 若存在则返回用户，反之则返回null
     */
    public User getUserByName(@Param("name") String name);

    /**
     * 添加用户
     * @param user
     * @return 更改的表的条数
     */
    public int addUser(User user);

    /**
     * 得到所有用户信息
     */
    public List<User> getAll();

    int insertDataUser(DataUser user);

    DataUser getByUsernameDataUser(String name);
}
