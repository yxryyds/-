package com.example.springBoot.utils;

import com.example.springBoot.model.User;
import com.example.springBoot.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.UUID;


@Component
public class AddUser {
    @Resource
    private UserService userService;

    public void addUser(){
        for(int i = 0; i < 100; i++){
            String name = UUID.randomUUID().toString();
            String pass = "123456789";
            userService.registerUser(new User(null, name, pass));
        }
    }

}
