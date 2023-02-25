package com.example.springBoot.model.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cource {
    private Integer id;
    private String no;
    private String name;
    private Integer priorId;
    private Integer credit;
}
