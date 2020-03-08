package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @GetMapping(value = "testAop")
    public void test(){
        System.out.println("執行程式");
    }
}
