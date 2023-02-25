package com.example.springBoot.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class ATest {

    @Resource
    ApplicationContext context;

    @Test
    public void testAT(){
        B b1 = context.getBean(B.class);
        B b2 = context.getBean(B.class);
        System.out.println(b1.getA() == b2.getA());
    }
}