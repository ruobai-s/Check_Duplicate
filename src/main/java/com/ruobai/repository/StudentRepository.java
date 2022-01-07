package com.ruobai.repository;

import com.ruobai.entity.Student;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepository{
    List<Student> findStudentInfo(int page, int limit);
    void updateStudent(String phone, String password, String college,String sno);
    void deleteStudent(String sno);
    Integer addStudentInfo(Student student);
    Long checkTotal();
    Student login(Integer sno,String password);
    boolean register(Student student);
}
