package com.example.springBoot.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "test")
public class Test {

    private String name;
    private String hobby;
    private Date date;
    private String[] strings;
    private List<String> list;
    private Map<String, Object> map;
    private Set<Double> set;

}
