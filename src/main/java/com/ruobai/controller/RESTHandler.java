package com.ruobai.controller;

import com.ruobai.entity.Student;
import com.ruobai.entity.Teacher;
import com.ruobai.service.ClassService;
import com.ruobai.service.SelfService;
import com.ruobai.service.StudentService;
import com.ruobai.vo.DataVO;
import com.ruobai.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTHandler {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SelfService selfService;
    @PostMapping("/studentData")
    public DataVO studentData(Integer page,Integer limit){
        return studentService.findStudentInfo(page,limit);
    }
    @PostMapping("/classInfoData")
    public DataVO classInfoData(Integer page, Integer limit){
        return classService.findClassInfo(page,limit);
    }
    @PostMapping("/selfInfoData")
    public DataVO selfInfoData(Integer page,Integer limit){
        return selfService.findSelfInfo(page,limit);
    }
    @PostMapping("/addStudent")
    public boolean addStudent(@RequestBody StudentVO studentVO){
        return studentService.addStudentInfo(studentVO);
    }
}
