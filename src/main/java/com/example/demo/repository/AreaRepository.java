package com.example.demo.repository;

import com.example.demo.entity.Area;
import com.example.demo.entity.Store;
import com.example.demo.model.StoreRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Integer> {
    List<Area> findByArea(String AreaName);
}
