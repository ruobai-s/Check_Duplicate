package com.ruobai.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int sno;
    private String name;
    private int sex;
    private String college;
    private int class_id;
    private String phone;
    private String password;

    public Student(String name, int sex, String college, int class_id, String phone, String password) {
        this.name = name;
        this.sex = sex;
        this.college = college;
        this.class_id = class_id;
        this.phone = phone;
        this.password = password;
    }
}
