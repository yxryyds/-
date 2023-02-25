package com.example.springBoot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/myController")
public class MyController {

    @RequestMapping("/login")
    public String login(){
        return "index";
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public AuthenticationToken userLogin(String name, String password){
        System.out.println(name+ " "+ password);
        // 获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 封装请求数据与token
        AuthenticationToken token = new UsernamePasswordToken(name, password);
        // 调用subject.login()进行登录认证
        try{
            subject.login(token);
            return token;
        }
        catch (Exception e){
            System.out.println("登入失败");
        }
        return null;
    }

    // 登陆验证角色
    @RequiresRoles("admin")
    @GetMapping("userRoles")
    @ResponseBody
    public String userRoles(){
        System.out.println("存在相关的角色");
        return "success";
    }

    //验证是否有file:write权限
    @RequiresPermissions("file:write")
    @GetMapping("userPer")
    @ResponseBody
    public String userPer(){
        System.out.println("存在相关的权限");
        return "success";
    }

}
