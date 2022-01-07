package com.ruobai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int course_id;
    private String course_name;
    private int course_times;
    private int credit;
}
