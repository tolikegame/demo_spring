package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "store_name")
    private String storeName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private List<Branch> stores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Branch> getStores() {
        return stores;
    }

    public void setStores(List<Branch> stores) {
        this.stores = stores;
    }
}
