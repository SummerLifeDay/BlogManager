package com.work.service.impl;

import com.work.mapper.OrderMapper;
import com.work.pojo.Order;
import com.work.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int add(Order order) {
        return mapper.insertSelective(order);
    }

    @Override
    public int edit(Order order) {
        return mapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int delete(String orderId) {
        return mapper.deleteByPrimaryKey(orderId);
    }

}
