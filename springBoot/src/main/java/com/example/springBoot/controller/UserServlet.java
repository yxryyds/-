package com.example.springBoot.controller;

import com.example.springBoot.model.User;
import com.example.springBoot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserServlet {

    @Resource
    private UserService userService;

    @Resource
    private User user;

//    @RequestMapping("login")
//    @ResponseBody
//    public User login(@RequestBody Map<String, Object> map, HttpServletRequest request){
//        user.setUsername((String) map.get("username"));
//        user.setPassword((String) map.get("password"));
//        return userService.loginUser(user);
//    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        log.info("进入login");
        return "register";
    }

    @RequestMapping("register")
    @ResponseBody
    public Map<String, String> register(@RequestBody Map<String, Object> map){
        user.setUsername((String) map.get("username"));
        user.setPassword((String) map.get("password"));
        User user1 = userService.containsUser(this.user);
        Map<String, String> mapRes = new HashMap<>();
        if (user1 == null){
            userService.registerUser(user);
            mapRes.put("register", "success");
        }
        else{
            mapRes.put("register", "fail");
        }
        return mapRes;
    }

    @ResponseBody
    @RequestMapping("testmapper/{username}/{password}")
    public User testMapper(@PathVariable("username") String username,
                           @PathVariable("password") String password){
        user.setUsername(username);
        user.setPassword(password);
        return userService.loginUser(user);
    }
}

