package com.finelite.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 程序启动类
 */
@SpringBootApplication
@ServletComponentScan
public class BlogWebApplication {

    public static void main(String[] args){
        SpringApplication.run(BlogWebApplication.class);
    }
}
