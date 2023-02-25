package com.example.springBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

    private A a;
    private String message = "i am B";

    public void setA(A a){
        this.a = a;
    }

    public A getA(){
        return a;
    }

    public String getMessage(){
        return message;
    }
}
