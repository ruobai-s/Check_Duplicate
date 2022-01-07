package com.ruobai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfoStatistic {
    private int id;
    private int class_id;
    private double usual_grades;
    private double usual_grades_average;
    private double final_grades;
    private double final_grades_average;
    private double overall_grades;
    private double overall_grades_average;
}
