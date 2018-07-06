package com.anyi.web;

import com.anyi.pojo.Order;
import com.anyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ResponseBody
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/findInfoById", method = RequestMethod.POST)
    public Optional<Order> findOrderById(@RequestBody Order order) {
        String order_id = order.getId();
        return orderService.findById(order_id);
    }

    @RequestMapping(value = "/order/findAllInfo", method = RequestMethod.POST)
    public Page<Order> findOrderById() {
        int page = 0;
        int size = 5;
        return orderService.findAll(page, size);
    }
    @RequestMapping(value = "/order/findOrderWithSort", method = RequestMethod.POST)
    public Page<Order> findOrderWithSort() {
        int page = 0;
        int size = 5;
        return orderService.findAll(page, size);
    }
}
