package com.qingyuan.redtour;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qingyuan.redtour.mapper")
public class RedTourApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedTourApplication.class, args);
    }

}
