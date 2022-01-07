package com.ruobai.repository;

import com.ruobai.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository {
    Teacher login(Integer username, String password);

    boolean register(Teacher teacher);
}
