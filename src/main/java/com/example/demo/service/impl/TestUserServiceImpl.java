package com.example.demo.service.impl;

import com.example.demo.entity.TestUser;
import com.example.demo.entity.User;
import com.example.demo.model.TestUserRequest;
import com.example.demo.repository.TestUserRepository;
import com.example.demo.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        //save後可以直接拿Entity得結果資料
        System.out.println(testUser.getId()+"----"+testUser.getAccount());
        return "新增成功";
    }

    @Override
    public String delete(TestUserRequest userRequest) {
        TestUser testUser = new TestUser();
        testUser.setId(1);
        testUserRepository.delete(testUser);

        return "刪除成功";
    }

    @Transactional  //綁交易最後有改變Entity物件會自動save
    @Override
    public void test() {
//        Optional<TestUser> testUser = testUserRepository.findById(1);
//        if(testUser.isPresent()){
//            testUser.get().setAccount("123");
//        }
        TestUser testUser1 = testUserRepository.getOne(1);
        testUser1.setAccount("456");
    }


}
