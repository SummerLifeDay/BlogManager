package com.work.service;

import com.work.pojo.Customer;
import com.work.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> selectAll();

    boolean add(Order order);

    boolean edit(Order order);

    boolean delete(String orderNum);

}
