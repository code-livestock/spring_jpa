package com.anyi.dao.impl;

import com.anyi.dao.OrderRepository;
import com.anyi.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderImpl {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    };

    public Page<Order> findAll(int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        return orderRepository.findAll(pageable);
    };

    public Page<Order> findOrderWithSort(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderAmount");
        Pageable   pageable =   new PageRequest(page,size,Sort.Direction.DESC,"orderAmount");
//        Pageable pageable =  PageRequest.of(page,size,Sort.Direction.ASC,"orderAmount");
        return orderRepository.findAll(pageable);

    };

}
