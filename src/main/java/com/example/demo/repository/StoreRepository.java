package com.example.demo.repository;

import com.example.demo.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Integer> {
    Store findByStoreName(String storeName);
    Page<Store> findAll(Pageable pageable);
}
