package com.ruobai.service.impl;

import com.ruobai.entity.Teacher;
import com.ruobai.repository.TeacherRepository;
import com.ruobai.repository.UtilsRepository;
import com.ruobai.service.TeacherService;
import com.ruobai.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UtilsRepository utilsRepository;
    @Override
    public TeacherVO login(String username, String password) {
        Teacher teacher = teacherRepository.login(Integer.valueOf(username),password);
        TeacherVO teacherVO = new TeacherVO();
        if (teacher==null) {
            return null;
        }else{
            teacherVO.setCourse(utilsRepository.checkCourse(teacher.getCourse_id()));
        }
        return teacherVO;
    }

    @Override
    public Boolean register(Teacher teacher) {
        if (teacherRepository.register(teacher)){
            return true;
        }else{
            return false;
        }
    }
}
