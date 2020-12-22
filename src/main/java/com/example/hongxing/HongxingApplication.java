package com.example.hongxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HongxingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HongxingApplication.class, args);
    }

}

//@SpringBootApplication
//public class HongxingApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(HongxingApplication.class);
//    }
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(HongxingApplication.class, args);
//    }
//
//}