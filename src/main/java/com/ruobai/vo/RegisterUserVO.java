package com.ruobai.vo;

import lombok.Data;

@Data
public class RegisterUserVO {
    private String name;
    private String password;
    private String wellPassword;
    private String college;
    private Integer class_id;
    private Integer course_id;
    private String phone;
    private Integer sex;
    private Integer userIdentity;
}
