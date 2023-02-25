package com.example.springBoot.model.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
    private Integer id;
    private String stuId;
    private String stuName;
    private String sex;
    private Integer age;
    private String dept;
    private List<ScResult> scResultList;
}
