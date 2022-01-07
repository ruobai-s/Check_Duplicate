package com.ruobai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ruobai.repository")
public class CheckDSApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckDSApplication.class,args);
    }
}
