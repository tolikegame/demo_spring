package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.model.StoreRequest;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping(value = "/addStore")
    public boolean addStore(@RequestBody StoreRequest storeRequest){
        return storeService.addStore(storeRequest);
    }

    @PutMapping(value = "/updateStore")
    public boolean updateStore(@RequestBody StoreRequest storeRequest){
        return storeService.updateSotre(storeRequest);
    }

    @DeleteMapping(value = "/deleteStore")
    public boolean deleteStore(@RequestParam int id){
        return storeService.deleteStore(id);
    }

    @PostMapping(value = "/allStore")
    public Page<Store> allStore(Pageable pageable){
        return storeService.allStore(pageable);
    }

}
