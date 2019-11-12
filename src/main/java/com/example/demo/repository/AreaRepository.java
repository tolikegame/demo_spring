package com.example.demo.repository;

import com.example.demo.entity.Area;
import com.example.demo.model.StoreRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area,Integer> {
    Area findByArea(String AreaName);
}
