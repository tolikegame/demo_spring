package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.UserRequest;

public interface HelloService {

    User findOne(String account);

    String insert(UserRequest userRequest);

    String delete(UserRequest userRequest);

}
