package com.example.demo;

import com.example.demo.config.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //springboot程序主入口
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);//注册监听
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

}
