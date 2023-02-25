package com.example.springBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class A {

    @Lazy
    @Autowired
    private B b;

    @PostConstruct
    public void init(){
        b.setA(this);
    }

    public B getB(){
        return b;
    }

}
