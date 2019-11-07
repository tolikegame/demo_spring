package com.example.demo.service.impl;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Store;
import com.example.demo.model.StoreRequest;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Transactional
    @Override
    public boolean addStore(StoreRequest storeRequest) {

        Store store = storeRepository.findByStoreName(storeRequest.getStoreName());
        if (null == store) {
            store = new Store();
        }
        store.setStoreName(storeRequest.getStoreName());

        Branch branch = new Branch();
        branch.setBranchName(storeRequest.getBranchName());
        branch.setPhone(storeRequest.getPhone());
        branch.setAddress(storeRequest.getAddress());
        branch.setStore(store);

        List<Branch> list = new ArrayList<>();
        list.add(branch);
        store.setStores(list);
        storeRepository.save(store);

        return true;
    }

    @Override
    public boolean updateSotre(StoreRequest storeRequest) {
//        Store store = storeRepository.getOne(storeRequest.getId());
        Store store = storeRepository.findById(storeRequest.getId()).get();
        store.setStoreName(storeRequest.getStoreName());
        storeRepository.save(store);

        return true;
    }

    @Override
    public boolean deleteStore(int id) {
        boolean check = storeRepository.existsById(id);
        if (!check){
            return false;
        }
        storeRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<Store> allStore(Pageable pageable) {

        return storeRepository.findAll(pageable);
    }
}
