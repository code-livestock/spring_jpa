package com.anyi.service;

import com.anyi.dao.impl.OrderImpl;
import com.anyi.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderImpl orderImpl;

    public Optional<Order> findById(String id) {
        return orderImpl.findById(id);
    }

    public Page<Order> findAll(int page, int size) {
        return orderImpl.findAll(page, size);
    }
    public Page<Order> findOrderWithSort(int page, int size){
        return  orderImpl.findOrderWithSort(page,size);
    }

}
