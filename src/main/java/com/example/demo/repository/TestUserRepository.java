package com.example.demo.repository;

import com.example.demo.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser,Integer> {
    TestUser findByAccount(String account);
}
