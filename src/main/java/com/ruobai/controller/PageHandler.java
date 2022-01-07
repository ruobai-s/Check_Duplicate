package com.ruobai.controller;

import com.ruobai.entity.Student;
import com.ruobai.entity.Teacher;
import com.ruobai.repository.UtilsRepository;
import com.ruobai.service.ClassService;
import com.ruobai.service.StudentService;

import com.ruobai.service.TeacherService;
import com.ruobai.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class PageHandler {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UtilsRepository utilsRepository;
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }
    @PutMapping("/updateStudent")
    @ResponseBody
    public void updateStudent(String phone,String password,String college,String sno){
        studentService.updateStudent(phone,password,college,sno);
    }
    @DeleteMapping("/deleteStudent")
    @ResponseBody
    public void deleteStudent(String sno){
        studentService.deleteStudent(sno);
    }
    @DeleteMapping("/deleteClass")
    @ResponseBody
    public void deleteClass(Integer id){
        classService.deleteClass(id);
    }
    @PutMapping("/updateClass")
    @ResponseBody
    public void updateClass(@RequestBody ClassInfoStatisticVO classInfoStatisticVO){
        classService.updateClass(classInfoStatisticVO);
    }
    @PostMapping("/loginUser")
    public String loginUser(CheckIdentity checkIdentity,Model model){
        //检查登录属性
        if (checkIdentity.getUserIdentity()==0){
            TeacherVO teacher = teacherService.login(checkIdentity.getUsername(), checkIdentity.getPassword());
            if (teacher!=null) {
                model.addAttribute("msg", teacher);
                return "teacher";
            }
        }else {
            //成功跳转
            StudentVO student = studentService.login(checkIdentity.getUsername(), checkIdentity.getPassword());
            if (student != null) {
                model.addAttribute("msg", student);
                return "student";
            }
        }
        model.addAttribute("msg", "error");
        return "login";
    }
    @PostMapping("/userRegister")
    @ResponseBody
    public String registerStudent(@RequestBody RegisterUserVO params,Model model){
        //教师注册
        Teacher teacher = new Teacher();
        Student student = new Student();
        if (params.getUserIdentity()==0){
            BeanUtils.copyProperties(params,teacher);
            if (teacherService.register(teacher)){
                return String.valueOf(teacher.getTno());
            }
        }else{//学生注册
            BeanUtils.copyProperties(params,student);
            if (studentService.register(student)) {
                return String.valueOf(student.getSno());
            }
        }
        return "false";
    }
    @PostMapping("/redirect")
    @ResponseBody
    public String redirects(String name,String text) throws Exception {
        text=text.replace(" ","");
        text=text.replace("\n","");
        text=urlEncodeChinese(text);
        name=urlEncodeChinese(name);
        String httpurl="http://101.37.174.206:8099/api/GetBd/text?text="+text+"&name"+name;
//        httpurl=urlEncodeChinese(httpurl);
        String res=get(httpurl);
        System.out.println(res);
        return res;
    }
    public static String urlEncodeChinese(String url) {
        try {
            Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(url);
            String tmp = "";
            while (matcher.find()) {
                tmp = matcher.group();
                url = url.replaceAll(tmp, URLEncoder.encode(tmp, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url.replace(" ","%20");
    }
    public String get(String url) throws Exception {
        String content = null;
        System.out.println(url);
        URLConnection urlConnection = new URL(url).openConnection();
        HttpURLConnection connection = (HttpURLConnection) urlConnection;
        connection.setRequestMethod("GET");
        //连接
        connection.connect();
        //得到响应码
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                    (connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder bs = new StringBuilder();
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                bs.append(l).append("\n");
            }
            content = bs.toString();
        }
        return content;
    }

}
