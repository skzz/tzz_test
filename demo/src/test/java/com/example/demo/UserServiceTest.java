package com.example.demo;


import com.example.demo.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = {App.class})
public class UserServiceTest {

    @Resource
    IUserService userService;


    @Test
    public void testBatchAdd(){
        userService.batchAdd("user03", "123");
    }
}
