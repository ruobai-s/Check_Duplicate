package com.ruobai.service.impl;

import com.ruobai.entity.Student;
import com.ruobai.repository.StudentRepository;
import com.ruobai.repository.UtilsRepository;
import com.ruobai.service.StudentService;
import com.ruobai.util.PageLimitUtil;
import com.ruobai.vo.DataVO;
import com.ruobai.vo.RegisterUserVO;
import com.ruobai.vo.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    /**分页显示
     *page：页数
     *limit：每次多少个数据
     * */
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PageLimitUtil pageLimitUtil;
    @Autowired
    private UtilsRepository utilsRepository;
    @Override
    public DataVO<Student> findStudentInfo(int page, int limit) {
        int index = pageLimitUtil.index(page);
        DataVO DataVO = new DataVO();
        DataVO.setCode(0);
        DataVO.setMsg("");
        List<Student> students = studentRepository.findStudentInfo(index,limit);
        List<StudentVO> studentVOArrayList = new ArrayList<>();
        for (Student student:students) {
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            studentVO.setClassroom(utilsRepository.checkName(student.getClass_id()));
            studentVOArrayList.add(studentVO);
        }
        DataVO.setCount(studentRepository.checkTotal());
        DataVO.setData(studentVOArrayList);
        return DataVO;
    }

    @Override
    public void updateStudent(String phone, String password,String college,String sno) {
        studentRepository.updateStudent(phone,password,college,sno);
    }


    @Override
    public void deleteStudent(String sno) {
        studentRepository.deleteStudent(sno);
    }

    @Override
    public Boolean addStudentInfo(StudentVO studentVO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVO,student);
        student.setClass_id( utilsRepository.checkId(studentVO.getClassroom()));
        int flag = studentRepository.addStudentInfo(student);
        if (flag>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public StudentVO login(String username,String password) {
        Student student = studentRepository.login(Integer.valueOf(username),password);
        StudentVO studentVO = new StudentVO();
        if (student==null) {
            return null;
        }else{
            studentVO.setClassroom(utilsRepository.checkName(student.getClass_id()));
            return studentVO;
        }
    }

    @Override
    public Boolean register(Student student) {
        if (studentRepository.register(student)){
            return true;
        }else{
            return false;
        }
    }
}
