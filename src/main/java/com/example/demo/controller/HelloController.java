package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.UserRequest;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping(value = "/findOne")
    public User findOne(@RequestParam String account){
        return helloService.findOne(account);
    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody @Valid UserRequest userRequest){
        return helloService.insert(userRequest);
    }

    @PostMapping(value = "delete")
    public String delete(@RequestBody UserRequest userRequest){
        return helloService.delete(userRequest);
    }


}
