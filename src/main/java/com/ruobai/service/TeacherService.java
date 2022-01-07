package com.ruobai.service;

import com.ruobai.entity.Teacher;
import com.ruobai.vo.TeacherVO;

public interface TeacherService {
    TeacherVO login(String username, String password);
    Boolean register(Teacher teacher);
}
