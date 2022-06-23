package com.work.service;

import com.work.pojo.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> selectAll();

    int add(Orders orders);

    int edit(Orders orders);

    int delete(String orderNum);

}
