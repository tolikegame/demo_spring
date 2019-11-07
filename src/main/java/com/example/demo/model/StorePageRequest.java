package com.example.demo.model;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class StorePageRequest {
    private Integer number = 0;
    private Integer size = 10;
    private String keyword;
    private String sortKey = "id";
    private Sort.Direction order = Sort.Direction.ASC;

    public static StorePageRequest of(String keyword, int number, int size){
        StorePageRequest result = new StorePageRequest();
        result.setKeyword(keyword);
        result.setNumber(number);
        result.setSize(size);

        return result;

    }

//    public Pageable getDefaultPageable(){
//        Sort sort = new Sort(order,sortKey);
//        return StorePageRequest.of(getNumber(),getSize(),sort);
//
//    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public Sort.Direction getOrder() {
        return order;
    }

    public void setOrder(Sort.Direction order) {
        this.order = order;
    }
}
