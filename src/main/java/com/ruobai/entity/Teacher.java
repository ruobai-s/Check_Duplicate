package com.ruobai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int tno;
    private String name;
    private int sex;
    private String college;
    private int course_id;
    private String phone;
    private String password;
}
