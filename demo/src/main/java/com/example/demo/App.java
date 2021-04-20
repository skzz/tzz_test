package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
@MapperScan("com.example.demo.dao")
@ComponentScan("com.example.demo.model")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
