package com.ruobai.qo;

import com.ruobai.entity.Class;
import com.ruobai.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoStatisticQO {
    private int id;
    private int sno;
    private String name;
    private int sex;
    private int class_id;
    private int course_id;
    private double usual_grades;
    private double final_grades;
    private double overall_grades;
    private Class aClass;
    private Course course;
}
