package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tpl")
public class ThymeleafController {

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(ModelMap map){
        map.addAttribute("name", "enjoy");
        return "testThymeleaf";
    }
}
