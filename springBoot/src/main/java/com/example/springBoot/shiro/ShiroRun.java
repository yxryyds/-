package com.example.springBoot.shiro;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class ShiroRun {
    public static void main(String[] args) throws JSONException {
//        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager instance = factory.getInstance();
//        SecurityUtils.setSecurityManager(instance);
//        // 获取subject对象
//        Subject subject = SecurityUtils.getSubject();
//        // 创建token对象，web应用用户名密码从页面传递
//        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "z3");
//        System.out.println(token);
//        // 完成登录
//        try{
//            subject.login(token);
//            System.out.println("login success");
//        }
//        catch(UnknownAccountException e){
//            e.printStackTrace();
//            System.out.println("用户不存在");
//        }
//        catch(IncorrectCredentialsException e){
//            e.printStackTrace();
//            System.out.println("密码错误");
//        }
//        catch (AuthenticationException e){
//            e.printStackTrace();
//        }

//        Md5Hash md5Hash = new Md5Hash("11111111", "salt", 5);
//        System.out.println(md5Hash.toHex());

        SimpleHash simpleHash = new SimpleHash("md5", "hello", "123456", 1024);
        System.out.println(simpleHash.toHex());

        String hello = new Md5Hash("hello", "123456", 1024).toHex();
        System.out.println(hello);
    }
}
