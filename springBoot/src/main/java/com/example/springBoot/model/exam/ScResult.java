package com.example.springBoot.model.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ScResult {
    private Integer scId;
    private Integer courseId;
    private String courseName;
    private Integer grade;
}
