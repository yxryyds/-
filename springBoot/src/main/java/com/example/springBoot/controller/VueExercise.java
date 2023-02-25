package com.example.springBoot.controller;

import com.example.springBoot.model.User;
import com.example.springBoot.service.UserService;
import com.example.springBoot.utils.AddUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class VueExercise {
    @Resource
    private UserService userService;


    @RequestMapping("/getall")
    public Map<String, Object> getUsers(@RequestBody Map<String, Object> page){
        log.info("按照起始点和每页大小得到对应数量的用户信息");
        Integer start = (Integer) page.get("start");
        Integer pageSize = (Integer) page.get("pageSize");
        List<User> users = userService.getUsers(start, pageSize);

        Map<String, Object> res = new HashMap<>();
        res.put("users", users);
        return res;
    }

    @RequestMapping("/query/{name}")
    public User queryUser(@PathVariable("name") String name){
        log.info("查询用户");
        return userService.containsUser(new User("", name, ""));
    }
}
