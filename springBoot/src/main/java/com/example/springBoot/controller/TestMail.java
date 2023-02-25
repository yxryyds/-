package com.example.springBoot.controller;

import com.example.springBoot.model.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller
public class TestMail {
    @Resource
    private JavaMailSender javaMailSender;

//    @Value("escms_ylhczx@163.com")
    @Value("${spring.mail.username}")
    private String from;

    @GetMapping("email/{email}")
    @ResponseBody
    public void sendEmail(@PathVariable("email") String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("测试是否可以发送文件");
        message.setText("来自： " + from + "的一封邮件！！！");
        javaMailSender.send(message);
    }

    @Resource
    private Test test;

    @ResponseBody
    @RequestMapping("test")
    public Test getTest(){
        log.info("测试slf4j日志功能，同时测试配置类配置bean");
        return test;
    }

}
