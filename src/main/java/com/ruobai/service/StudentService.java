package com.ruobai.service;


import com.ruobai.entity.Student;
import com.ruobai.entity.Teacher;
import com.ruobai.vo.DataVO;
import com.ruobai.vo.RegisterUserVO;
import com.ruobai.vo.StudentVO;

public interface StudentService {
    DataVO<Student> findStudentInfo(int page, int limit);
    void updateStudent(String phone, String password, String college,String sno);
    void deleteStudent(String sno);
    Boolean addStudentInfo(StudentVO studentVO);
    StudentVO login(String username,String password);
    Boolean register(Student student);
}
