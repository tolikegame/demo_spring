package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.model.UserRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findOne(String account) {
        return userRepository.findByAccount(account);
    }

    @Override
    public String insert(UserRequest userRequest) {
        User user = new User();
        user.setAccount(userRequest.getAccount());
        user.setPassword(userRequest.getPassword());
        user.seteMail(userRequest.geteMail());
        user.setPhone(userRequest.getPhone());
        userRepository.save(user);
        return "新增成功";
    }

    @Override
    public String delete(UserRequest userRequest) {
        User user = new User();
        user.setId(1);
        userRepository.delete(user);

        return "刪除成功";
    }


}
