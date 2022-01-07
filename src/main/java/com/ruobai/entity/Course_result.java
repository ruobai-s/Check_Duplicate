package com.ruobai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course_result {
    private int sno;
    private String name;
    private int class_id;
    private double usual_grades;
    private double final_grades;
}
