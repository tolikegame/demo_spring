package com.example.demo.controller;

import com.example.demo.entity.TestUser;
import com.example.demo.entity.User;
import com.example.demo.model.TestUserRequest;
import com.example.demo.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestUserController {

    @Autowired
    TestUserService testUserService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping(value = "/findOne")
    public TestUser findOne(@RequestParam String account){
        return testUserService.findOne(account);
    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody TestUserRequest userRequest){
        return testUserService.insert(userRequest);
    }

    @PostMapping(value = "delete")
    public String delete(@RequestBody TestUserRequest userRequest){
        return testUserService.delete(userRequest);
    }


}
