package com.work.service;

import com.work.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> selectAll();

    int add(Order order);

    int edit(Order order);

    int delete(String orderNum);

}
