package com.example.demo.service;

import com.example.demo.entity.TestUser;
import com.example.demo.entity.User;
import com.example.demo.model.TestUserRequest;

public interface TestUserService {

    TestUser findOne(String account);

    String insert(TestUserRequest userRequest);

    String delete(TestUserRequest userRequest);

    void test();

}
