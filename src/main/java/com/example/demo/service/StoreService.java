package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.model.StoreRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreService {
    boolean addStore(StoreRequest storeRequest);

    boolean updateSotre(StoreRequest storeRequest);

    boolean deleteStore(int id);

    Page<Store> allStore(Pageable pageable);
}
