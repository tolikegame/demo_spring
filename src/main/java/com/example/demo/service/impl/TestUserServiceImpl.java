package com.example.demo.service.impl;

import com.example.demo.entity.TestUser;
import com.example.demo.entity.User;
import com.example.demo.model.TestUserRequest;
import com.example.demo.repository.TestUserRepository;
import com.example.demo.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    TestUserRepository testUserRepository;

    @Override
    public TestUser findOne(String account) {
        return testUserRepository.findByAccount(account);
    }

    @Override
    public String insert(TestUserRequest userRequest) {
        TestUser testUser = new TestUser();
        testUser.setAccount(userRequest.getAccount());
        testUser.setPassword(userRequest.getPassword());
        testUser.seteMail(userRequest.geteMail());
        testUser.setPhone(userRequest.getPhone());
        testUserRepository.save(testUser);
        return "新增成功";
    }

    @Override
    public String delete(TestUserRequest userRequest) {
        TestUser testUser = new TestUser();
        testUser.setId(1);
        testUserRepository.delete(testUser);

        return "刪除成功";
    }


}
