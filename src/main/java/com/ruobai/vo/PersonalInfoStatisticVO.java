package com.ruobai.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoStatisticVO {
    private int id;
    private int sno;
    private String name;
    private int sex;
    private String class_name;
    private String course_name;
    private double usual_grades;
    private double final_grades;
    private double overall_grades;
}
