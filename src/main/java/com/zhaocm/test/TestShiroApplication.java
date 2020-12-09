package com.zhaocm.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhaocm.test.mapper")
public class TestShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestShiroApplication.class, args);
    }

}
