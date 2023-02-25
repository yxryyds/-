package com.example.springBoot.service.impl;

import com.example.springBoot.service.UserService;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;


class UserServiceImplTest {
    @Resource
    private UserService userService;

//    public List<User> getUsers(Integer start, Integer pageSize) {
    @Test
    public void testGetUsers(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < 5 ; i++){
            sb.append(s.charAt(new Random().nextInt(s.length())));
        }
        System.out.println(sb);
    }
}