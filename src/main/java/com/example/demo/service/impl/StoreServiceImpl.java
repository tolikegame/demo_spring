package com.example.demo.service.impl;

import com.example.demo.entity.Area;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Store;
import com.example.demo.model.StoreRequest;
import com.example.demo.repository.AreaRepository;
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

    @Autowired
    AreaRepository areaRepository;

    @Transactional
    @Override
    public boolean addStore(StoreRequest storeRequest) {

        Store store = storeRepository.findByStoreName(storeRequest.getStoreName());
        if (null == store) {    //如找不到就是新增
            store = new Store();
        }
        store.setStoreName(storeRequest.getStoreName());

        List<Area> areaList = store.getAreas();
        if(null == areaList){   //如商家已有，沿用原本資料，不新增
            areaList = new ArrayList<>();
        }
        Area area = new Area();
        for(Area areaTemp : areaList){
            if(areaTemp.getArea().equals(storeRequest.getArea())){  //已有地區資料會沿用，不新增
                area = areaTemp;
            }
        }

        area.setArea(storeRequest.getArea());
        area.setStore(store);   //儲存商店的id
        areaList.add(area);
        store.setAreas(areaList);

        Branch branch = new Branch();
        branch.setBranchName(storeRequest.getBranchName());
        branch.setPhone(storeRequest.getPhone());
        branch.setAddress(storeRequest.getAddress());
        branch.setArea(area);

        List<Branch> branchList = new ArrayList<>();
        branchList.add(branch);
        area.setBranches(branchList);

        storeRepository.save(store);

        return true;
    }

    @Override
    public boolean updateSotre(StoreRequest storeRequest) {
        Store store = storeRepository.getOne(storeRequest.getId());
        store.setStoreName(storeRequest.getStoreName());

        List<Area> areas = store.getAreas();
        for(Area area : areas){ //找出要改的地區
            if(area.getArea().equals(storeRequest.getArea())){
                area.setArea(storeRequest.getReArea());
            }
        }
        store.setAreas(areas);

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
