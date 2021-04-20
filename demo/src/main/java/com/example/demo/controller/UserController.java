package com.example.demo.controller;


import com.example.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {


    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    IUserService userService;

    @RequestMapping("/hello")
    public Object sayHello(){
        logger.info("这是一个hello日志");
        return "hello 9";
    }


    @RequestMapping("/login")
    public String login(String username, String passwd){

        if(userService.login(username, passwd)){
            return "登录成功";
        }else{
            return "登录失败";
        }
    }

    @RequestMapping("/register")
    public String register(String username, String passwd){

        boolean login = userService.register(username,passwd);
        if(login){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }

    @RequestMapping("/batchAdd")
    public void batchAdd(String username, String passwd){

        userService.batchAdd(username,passwd);

    }

}
