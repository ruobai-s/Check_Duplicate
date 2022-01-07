package com.ruobai.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UtilsRepository {
    int checkId(String class_name);
    String checkName(int class_id);

    String checkCourse(int course_id);
}
